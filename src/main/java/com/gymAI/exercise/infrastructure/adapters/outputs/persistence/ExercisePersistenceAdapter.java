package com.gymAI.exercise.infrastructure.adapters.outputs.persistence;

import com.gymAI.exercise.application.ports.outputs.ExercisePersistencePort;
import com.gymAI.exercise.domain.model.Exercise;
import com.gymAI.exercise.infrastructure.adapters.outputs.persistence.mapper.ExercisePersistenceMapper;
import com.gymAI.exercise.infrastructure.adapters.outputs.persistence.repository.ExerciseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class ExercisePersistenceAdapter implements ExercisePersistencePort {

    private ExerciseRepository exerciseRepository;
    private ExercisePersistenceMapper mapper;
    @Override
    public Optional<Exercise> findById(Long id) {
        return exerciseRepository.findById(id).map((exerciseEntity)->
                mapper.toExercise(exerciseEntity)
        );

    }

    @Override
    public List<Exercise> getAll() {
        return mapper.toExerciseList(exerciseRepository.findAll());
    }

    @Override
    public Exercise save(Exercise exercise){
        return mapper.toExercise(exerciseRepository.save(mapper.toExerciseEntity(exercise)));
    }

    @Override
    public void deleteById(Long id) {
        exerciseRepository.deleteById(id);
    }
}
