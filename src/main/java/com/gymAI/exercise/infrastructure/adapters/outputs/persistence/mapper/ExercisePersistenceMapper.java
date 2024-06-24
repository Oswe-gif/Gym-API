package com.gymAI.exercise.infrastructure.adapters.outputs.persistence.mapper;

import com.gymAI.exercise.domain.model.Exercise;
import com.gymAI.exercise.infrastructure.adapters.outputs.persistence.entity.ExerciseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExercisePersistenceMapper {
    ExerciseEntity toExerciseEntity(Exercise exercise);
    Exercise toExercise(ExerciseEntity exerciseEntity);
    List<Exercise> toExerciseList(List<ExerciseEntity> exerciseEntityList);
}
