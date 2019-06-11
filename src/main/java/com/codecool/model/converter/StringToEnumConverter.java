package com.codecool.model.converter;

import com.codecool.model.ArtifactCategory;
import org.springframework.core.convert.converter.Converter;

import java.beans.PropertyEditorSupport;
import java.util.Currency;

public class StringToEnumConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String capitalized = text.toUpperCase();
        ArtifactCategory artifactCategory = ArtifactCategory.valueOf(capitalized);
        setValue(artifactCategory);
    }
}

//public class StringToEnumConverter implements Converter<String, ArtifactCategory> {
//
//    @Override
//    public ArtifactCategory convert(String from) {
//        return ArtifactCategory.valueOf(from);
//    }
//}
