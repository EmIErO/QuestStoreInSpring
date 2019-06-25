package com.codecool.controller;

import com.codecool.model.Artifact;
import com.codecool.model.ArtifactCategory;
import com.codecool.model.converter.StringToEnumConverter;
import com.codecool.model.wrapper.ListWrapper;
import com.codecool.service.ArtifactService;
import com.codecool.validator.ArtifactValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    private ArtifactValidator validator;

    @Autowired
    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @RequestMapping
    public String showDefault(Model model) {
        model.addAttribute("artifacts", artifactService.getAllArtifacts());
        return "artifacts";
    }

    @RequestMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_HTML_VALUE, MediaType.APPLICATION_XML_VALUE})
    public String listAll(Model model) {
        model.addAttribute("artifactsWrapper", new ListWrapper<Artifact>(artifactService.getAllArtifacts()));
        return "artifacts";
    }

    @RequestMapping("/{id}")
    public Artifact getArtifactById(@PathVariable int id) {
        return artifactService.getArtifactById(id);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddArtifactForm(Model model) {
        Artifact artifact = new Artifact();
        model.addAttribute("newArtifact", artifact);
        return "addArtifact";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewArtifactForm(@ModelAttribute("newArtifact") Artifact artifactToBeAdded, BindingResult result, HttpServletRequest request) {

        validator.validate(artifactToBeAdded,result);

        if (result.hasErrors()) {
            return "addArtifact";
        }

        MultipartFile artifactImg = artifactToBeAdded.getArtifactImage();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");

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
        model.addAttribute("artifactsWrapper", new ListWrapper<Artifact>(artifactService.getArtifactByCategory(category)));
        return "artifacts";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(ArtifactCategory.class, new StringToEnumConverter());
    }
}
