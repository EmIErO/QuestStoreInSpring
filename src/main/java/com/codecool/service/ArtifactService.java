package com.codecool.service;

import com.codecool.model.Artifact;
import com.codecool.model.ArtifactCategory;

import java.util.List;

public interface ArtifactService {

    List<Artifact> getAllArtifacts();

    List<Artifact> getArtifactByCategory(ArtifactCategory category);

    void addArtifact(Artifact artifact);

    Artifact getArtifactById(int id);
}
