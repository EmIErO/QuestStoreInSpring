package com.codecool.model.wrapper;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@JsonIgnoreProperties(value = "artifactList")
@XmlRootElement
public class ListWrapper<T> {

    private List<T> content;

    public ListWrapper() {}
    public ListWrapper(List<T> content) {
        this.content = content;
    }

    @XmlElementWrapper(name = "objects")
    @XmlElement(name = "element")
    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> objectList) {
        this.content = objectList;
    }
}
