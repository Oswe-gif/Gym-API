package com.gymAI.exercise.infrastructure.adapters.inputs.rest.mapper;

import com.gymAI.exercise.domain.model.Exercise;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.request.ExerciseCreateRequest;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.response.ExerciseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExerciseRestMapper {
    Exercise toExercise(ExerciseCreateRequest exerciseCreateRequest);
    ExerciseResponse toExerciseResponse(Exercise exercise);
    List<ExerciseResponse> toExerciseResponseList(List<Exercise> exercises);
}
