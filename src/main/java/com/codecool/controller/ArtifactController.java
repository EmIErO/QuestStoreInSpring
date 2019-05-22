package com.codecool.controller;

import com.codecool.model.Artifact;
import com.codecool.repo.ArtifactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArtifactController {

    private ArtifactRepo artifactRepo;

    @Autowired
    public ArtifactController(ArtifactRepo artifactRepo) {
        this.artifactRepo = artifactRepo;
    }

    @RequestMapping("/artifacts")
    public String list(Model model) {
        model.addAttribute("artifacts", artifactRepo.getAllArtifacts());
        return "artifacts";
    }
}
