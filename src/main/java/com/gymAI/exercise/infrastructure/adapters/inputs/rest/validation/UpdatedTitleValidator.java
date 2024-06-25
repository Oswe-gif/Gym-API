package com.gymAI.exercise.infrastructure.adapters.inputs.rest.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UpdatedTitleValidator implements ConstraintValidator<UpdatedTitle, String> {
    @Override
    public void initialize(UpdatedTitle title) {
        ConstraintValidator.super.initialize(title);
    }

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        if(o == null){
            return true;
        }
        return !o.isBlank();
    }
}
