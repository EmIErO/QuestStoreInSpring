package com.codecool.controller;

import com.codecool.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String list(Model model) {
        model.addAttribute("artifacts", artifactService.getAllArtifacts());
        return "artifacts";
    }
}
