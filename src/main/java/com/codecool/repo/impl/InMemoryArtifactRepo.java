package com.codecool.repo.impl;

import com.codecool.model.Artifact;
import com.codecool.model.ArtifactCategory;
import com.codecool.repo.ArtifactRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryArtifactRepo implements ArtifactRepo {

    private List<Artifact> listOfArtifacts = new ArrayList<>();

    public InMemoryArtifactRepo() {
        Artifact consultation = new Artifact("Consultation", 50,
                "One hour of private consultation with chosen mentor.",
                ArtifactCategory.INDIVIDUAL);
        consultation.setArtifactId(1);

        Artifact tipping = new Artifact("Crown of prestige", 20,
                "The student can use jukebox exclusively for half day.",
                ArtifactCategory.INDIVIDUAL);
        tipping.setArtifactId(2);

        Artifact crown = new Artifact("Crown of prestige", 20,
                "You can wear the Crown of prestige for a whole day and thus everyone in your room should call you by a title of your choice (first student who pays on that day).",
                ArtifactCategory.INDIVIDUAL);
        crown.setArtifactId(3);

        Artifact teleport = new Artifact("Teleport", 40,
                "The whole room goes to an off-school program instead for a specified day (which is at least 2 weeks ahead).",
                ArtifactCategory.GROUP);
        teleport.setArtifactId(4);

        listOfArtifacts.add(consultation);
        listOfArtifacts.add(tipping);
        listOfArtifacts.add(crown);
        listOfArtifacts.add(teleport);

    }

    @Override
    public List<Artifact> getAllArtifacts() {
        return listOfArtifacts;
    }

    @Override
    public Artifact getArtifactById(int id) {
//        Artifact artifactById = null;

        for (Artifact artifact : listOfArtifacts)
            if (artifact.getArtifactId() == id) return artifact;
        throw new IllegalArgumentException("Artifact with id: " + id + " does not exist.");
    }
}
