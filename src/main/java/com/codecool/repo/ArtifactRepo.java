package com.codecool.repo;

import com.codecool.model.Artifact;

import java.util.List;

public interface ArtifactRepo {

    List<Artifact> getAllArtifacts();

    Artifact getArtifactById(int id);

    void addArtifact(Artifact artifact);
}
