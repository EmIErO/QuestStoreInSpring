package com.codecool.service.impl;

import com.codecool.model.Artifact;
import com.codecool.repo.ArtifactRepo;
import com.codecool.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtifactServiceImpl implements ArtifactService {

    private ArtifactRepo artifactRepo;

    @Autowired
    public ArtifactServiceImpl(ArtifactRepo artifactRepo) {
        this.artifactRepo = artifactRepo;
    }

    @Override
    public List<Artifact> getAllArtifacts() {
        return artifactRepo.getAllArtifacts();
    }
}
