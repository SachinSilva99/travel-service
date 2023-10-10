package com.sachin.travelservice.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = GuideIdRequiredValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface GuideIdRequired {
    String message() default "Guide ID is required when 'isWithGuide' is true.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
