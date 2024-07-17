package com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoutineCreateRequest {
    private Long id;
    private Long ids_exercises[];
    private String title;

}
