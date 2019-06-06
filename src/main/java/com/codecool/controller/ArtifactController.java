package com.codecool.controller;

import com.codecool.model.Artifact;
import com.codecool.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String processAddNewArtifactForm(@ModelAttribute("newArtifact") Artifact newArtifact) {
        artifactService.addArtifact(newArtifact);
        return "redirect: /artifacts";
    }
}
