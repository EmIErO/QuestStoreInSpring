package com.codecool.repo;

import com.codecool.model.Artifact;
import com.codecool.model.ArtifactCategory;

import java.util.List;

public interface ArtifactRepo {

    List<Artifact> getAllArtifacts();

    Artifact getArtifactById(int id);

    List<Artifact> getArtifactsByCategory(ArtifactCategory category);

    void addArtifact(Artifact artifact);
}
