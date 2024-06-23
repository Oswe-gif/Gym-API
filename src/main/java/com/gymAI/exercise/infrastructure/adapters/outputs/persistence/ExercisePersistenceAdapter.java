package com.gymAI.exercise.infrastructure.adapters.outputs.persistence;

import com.gymAI.exercise.application.ports.outputs.ExercisePersistencePort;
import com.gymAI.exercise.domain.model.Exercise;
import com.gymAI.exercise.infrastructure.adapters.outputs.persistence.mapper.ExercisePersistenceMapper;
import com.gymAI.exercise.infrastructure.adapters.outputs.persistence.repository.ExerciseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ExercisePersistenceAdapter implements ExercisePersistencePort {

    private ExerciseRepository exerciseRepository;
    private ExercisePersistenceMapper exercisePersistenceMapper;
    @Override
    public Optional<Exercise> findById(Long id) {
        return exerciseRepository.findById(id).map((exerciseEntity)->
            exercisePersistenceMapper.toExercise(exerciseEntity)
        );

    }
}
