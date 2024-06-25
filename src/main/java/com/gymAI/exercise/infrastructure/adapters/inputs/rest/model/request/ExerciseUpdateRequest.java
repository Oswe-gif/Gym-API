package com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.request;

import com.gymAI.exercise.infrastructure.adapters.inputs.rest.validation.UpdatedTitle;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExerciseUpdateRequest {
    @UpdatedTitle(message = "Field title can not be empty")
    private String title;
    private String details;
}
