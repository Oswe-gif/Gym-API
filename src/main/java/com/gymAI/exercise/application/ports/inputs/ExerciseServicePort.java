package com.gymAI.exercise.application.ports.inputs;

import com.gymAI.exercise.domain.model.Exercise;

public interface ExerciseServicePort {
    //todas las operaciones de mi service. Los casos de uso
    Exercise findById(Long id);
    Exercise save(Exercise exercise);
}
