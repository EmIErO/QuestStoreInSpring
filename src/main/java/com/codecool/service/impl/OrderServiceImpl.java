package com.codecool.service.impl;

import com.codecool.model.Artifact;
import com.codecool.repo.ArtifactRepo;
import com.codecool.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private ArtifactRepo artifactRepo;

    @Autowired
    public OrderServiceImpl(ArtifactRepo artifactRepo) {
        this.artifactRepo = artifactRepo;
    }

    @Override
    public void proccessOrder(int artifactId) {
        Artifact artifactById = artifactRepo.getArtifactById(artifactId);
        // add purchase to users history
        System.out.println("Product was bought: " + artifactById.toString());

    }
}
