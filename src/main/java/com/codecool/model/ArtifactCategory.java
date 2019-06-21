package com.codecool.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
