package com.gymAI.exercise.infrastructure.adapters.inputs.rest.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UpdatedTitleValidator.class)
@Documented
public @interface UpdatedTitle {
    String message();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
