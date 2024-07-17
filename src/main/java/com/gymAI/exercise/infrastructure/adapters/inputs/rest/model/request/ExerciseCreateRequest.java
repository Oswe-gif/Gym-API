package com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.request;

import com.gymAI.exercise.domain.model.Routine;
import com.gymAI.exercise.infrastructure.adapters.outputs.persistence.entity.RoutineEntity;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ExerciseCreateRequest {
    @NotBlank(message = "Field title can not be empty")
    private String title;
    private String details;
    private List<Routine> routines;
}
