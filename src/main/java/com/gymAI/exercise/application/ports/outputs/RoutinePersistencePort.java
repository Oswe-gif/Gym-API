package com.gymAI.exercise.application.ports.outputs;

import com.gymAI.exercise.domain.model.Routine;

import java.util.List;
import java.util.Optional;

public interface RoutinePersistencePort {
    List<Routine> getAll();
    Routine save(Routine routine);
    Optional<Routine> findById(Long id);

}
