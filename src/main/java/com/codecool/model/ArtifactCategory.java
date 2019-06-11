package com.codecool.model;

public enum ArtifactCategory {
    GROUP {
        public String toString() {
            return "Group";
        }
    },
    INDIVIDUAL {
        public String toString() {
            return "Individual";
        }
    }
}
