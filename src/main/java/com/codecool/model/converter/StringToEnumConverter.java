package com.codecool.model.converter;

import com.codecool.model.ArtifactCategory;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToEnumConverter implements Converter<String, ArtifactCategory> {

    @Override
    public ArtifactCategory convert(String from) {
        return ArtifactCategory.valueOf(from);
    }
}
