package com.codecool.controller;

import com.codecool.model.Artifact;
import com.codecool.model.ArtifactCategory;
import com.codecool.model.converter.StringToEnumConverter;
import com.codecool.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@RequestMapping("/artifacts")
@Controller
public class ArtifactController {

    private ArtifactService artifactService;

    @Autowired
    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @RequestMapping
    public String showDefault(Model model) {
        model.addAttribute("artifacts", artifactService.getAllArtifacts());
        return "artifacts";
    }

    @RequestMapping("/all")
    public String listAll(Model model) {
        model.addAttribute("artifacts", artifactService.getAllArtifacts());
        return "artifacts";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddArtifactForm(Model model) {
        Artifact artifact = new Artifact();
        model.addAttribute("newArtifact", artifact);
        return "addArtifact";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewArtifactForm(@ModelAttribute("newArtifact") Artifact artifactToBeAdded, HttpServletRequest request) {
        MultipartFile artifactImg = artifactToBeAdded.getArtifactImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        System.out.println(rootDirectory);

        if (artifactImg != null && !artifactImg.isEmpty()) {
            try {
                artifactImg.transferTo(new File(rootDirectory + "/resources/images/"
                        + artifactToBeAdded.getName() + ".jpg"));

            } catch (Exception e) {
                throw new RuntimeException("Saving artifact's image was unsuccessful", e);
            }
        }
        artifactService.addArtifact(artifactToBeAdded);
        return "redirect:/artifacts";
    }

    @RequestMapping("/category/{category}")
    public String getArtifactsByCategory(Model model, @PathVariable ArtifactCategory category) {
        model.addAttribute("artifacts", artifactService.getArtifactByCategory(category));
        return "artifacts";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(ArtifactCategory.class, new StringToEnumConverter());
    }
}
