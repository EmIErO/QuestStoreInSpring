package com.codecool.controller;

import com.codecool.model.Artifact;
import com.codecool.model.ArtifactCategory;
import org.springframework.test.util.ReflectionTestUtils;

public class ArtifactBuilder {

    private Artifact model;

    public ArtifactBuilder() {
        this.model = new Artifact();
    }

    public ArtifactBuilder id(int id) {
        ReflectionTestUtils.setField(model, "artifactId", id);
        return this;
    }

    public ArtifactBuilder name(String name) {
        model.setName(name);
        return this;
    }

    public ArtifactBuilder price(int price) {
        model.setPrice(price);
        return this;
    }

    public ArtifactBuilder description(String description) {
        model.setDescription(description);
        return this;
    }

    public ArtifactBuilder category(ArtifactCategory category) {
        model.setCategory(category);
        return this;
    }

    public Artifact build() {
        return model;
    }
}




