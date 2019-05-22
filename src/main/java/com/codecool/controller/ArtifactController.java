package com.codecool.controller;

import com.codecool.model.Artifact;
import com.codecool.repo.ArtifactRepo;
import com.codecool.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtifactController {

    private ArtifactService artifactService;

    @Autowired
    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @RequestMapping("/artifacts")
    public String list(Model model) {
        model.addAttribute("artifacts", artifactService.getAllArtifacts());
        return "artifacts";
    }
}
