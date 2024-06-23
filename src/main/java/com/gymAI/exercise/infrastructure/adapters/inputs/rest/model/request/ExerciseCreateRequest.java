package com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExerciseCreateRequest {
    @NotBlank(message = "Field title can not be empty")
    private String title;
    private String details;
}
