package com.codecool.model;

import java.util.Objects;

public class Artifact {

    private int artifactId;
    private String name;
    private int price;
    private String description;
    private ArtifactCategory category;

    public Artifact(String name, int price, String description, ArtifactCategory category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Artifact() {}

    public int getArtifactId() {
        return artifactId;
    }

    public void setArtifactId(int artifactId) {
        this.artifactId = artifactId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArtifactCategory getCategory() {
        return category;
    }

    public void setCategory(ArtifactCategory category) {
        this.category = category;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artifact artifact = (Artifact) o;
        return artifactId == artifact.artifactId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(artifactId);
    }

    @Override
    public String toString() {
        return "Artifact{" +
                "artifactId=" + artifactId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category.toString() + '\'' +
                '}';
    }
}
