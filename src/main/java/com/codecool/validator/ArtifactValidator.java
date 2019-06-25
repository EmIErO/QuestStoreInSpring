package com.codecool.validator;

import com.codecool.model.Artifact;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ArtifactValidator implements Validator {

    public boolean supports(Class clazz) {
        return Artifact.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "name", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "price", "field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(e, "description", "field.required");
        ValidationUtils.rejectIfEmpty(e, "category", "category.empty");

        Artifact artifact = (Artifact) obj;

        String name = artifact.getName();
        if (name.length() < 3 || name.length() > 20) {
            e.rejectValue("name", "artifact.name.validation");
        }

        int price = artifact.getPrice();
        if (price < 1 || price > 1000) {
            e.rejectValue("price", "artifact.price.validation");
        }
    }
}
