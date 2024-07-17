package com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.response;

import com.gymAI.exercise.domain.model.Exercise;
import com.gymAI.exercise.infrastructure.adapters.outputs.persistence.entity.ExerciseEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
public class RoutineResponse {
    private Long id;
    private List<Exercise> exercises;
    private String title;
}
