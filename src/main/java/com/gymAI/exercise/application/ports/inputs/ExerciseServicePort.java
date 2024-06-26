package com.gymAI.exercise.application.ports.inputs;

import com.gymAI.exercise.domain.model.Exercise;

import java.util.List;

public interface ExerciseServicePort {
    //todas las operaciones de mi service. Los casos de uso
    Exercise findById(Long id);
    List<Exercise> getAll();
    Exercise save(Exercise exercise);
    void deleteById(Long id);
    Exercise update(Exercise exercise, Long id);
    List<Exercise> findAllById(List<Long> ids);
}
