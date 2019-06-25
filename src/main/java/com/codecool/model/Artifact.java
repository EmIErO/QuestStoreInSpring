package com.codecool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;
import java.util.Objects;

@XmlRootElement
public class Artifact {

    private int artifactId;
//    @NotNull(message = "label.notNull.message")
//    @Size(min = 3, max = 20, message = "size.artifact.name.validation")
    private String name;
    private int price;
//    @NotNull(message = "label.notNull.message")
//    @Size(min = 5, max = 100, message = "size.artifact.description.validation")
    private String description;
    private ArtifactCategory category;
    @JsonIgnore
    private MultipartFile artifactImage;

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

    @XmlTransient
    public MultipartFile getArtifactImage() {
        return artifactImage;
    }

    public void setArtifactImage(MultipartFile artifactImage) {
        this.artifactImage = artifactImage;
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
