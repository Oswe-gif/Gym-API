package com.gymAI.exercise.application.ports.inputs;

import com.gymAI.exercise.domain.model.Routine;
import com.gymAI.exercise.domain.model.RoutineCreator;

import java.util.List;

public interface RoutineServicePort {
    List<Routine> getAll();
    Routine save(RoutineCreator routine);
    Routine findById(Long id);
}
