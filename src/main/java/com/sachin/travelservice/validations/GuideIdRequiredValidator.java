package com.sachin.travelservice.validations;

import com.sachin.travelservice.dto.TravelDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GuideIdRequiredValidator implements ConstraintValidator<GuideIdRequired, TravelDTO> {
    @Override
    public void initialize(GuideIdRequired constraintAnnotation) {
    }

    @Override
    public boolean isValid(TravelDTO travelDTO, ConstraintValidatorContext context) {
        if (travelDTO == null) {
            return true;
        }
        return !travelDTO.isWithGuide() || travelDTO.getGuideId() != null;
    }
}

