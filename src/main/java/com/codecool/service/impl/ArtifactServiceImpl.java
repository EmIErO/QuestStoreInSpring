package com.codecool.service.impl;

import com.codecool.model.Artifact;
import com.codecool.model.ArtifactCategory;
import com.codecool.repo.ArtifactRepo;
import com.codecool.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("!test")
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

    @Override
    public Artifact getArtifactById(int id) {
        return artifactRepo.getArtifactById(id);
    }

    @Override
    public void addArtifact(Artifact artifact) {
        artifactRepo.addArtifact(artifact);
    }

    @Override
    public List<Artifact> getArtifactByCategory(ArtifactCategory category) {
        return artifactRepo.getArtifactsByCategory(category);
    }
}
