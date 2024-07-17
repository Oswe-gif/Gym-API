package com.gymAI.exercise.application.services;

import com.gymAI.exercise.application.ports.inputs.RoutineServicePort;
import com.gymAI.exercise.application.ports.outputs.ExercisePersistencePort;
import com.gymAI.exercise.application.ports.outputs.RoutinePersistencePort;
import com.gymAI.exercise.domain.exception.ExerciseNotFoundException;
import com.gymAI.exercise.domain.model.Exercise;
import com.gymAI.exercise.domain.model.Routine;
import com.gymAI.exercise.domain.model.RoutineCreator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoutineService implements RoutineServicePort {
    RoutinePersistencePort routinePersistencePort;
    ExercisePersistencePort exercisePersistencePort;
    @Override
    public List<Routine> getAll() {
        List<Routine> routines= routinePersistencePort.getAll();
        if (!routines.isEmpty()){
            return routines;
        }
        throw new ExerciseNotFoundException();

    }

    @Override
    public Routine save(RoutineCreator routine) {
        boolean validExercise;
        for(Long id: routine.getIds_exercises()){
            validExercise = exercisePersistencePort.existsById(id);
            if (!validExercise){
                throw  new ExerciseNotFoundException();
            }

        }
        List<Exercise> exercises= exercisePersistencePort.findAllById(List.of(routine.getIds_exercises()));
        Routine routine1 = Routine.builder()
                .title(routine.getTitle())
                .exercises(exercises)
                .build();
        return routinePersistencePort.save(routine1);
    }

    @Override
    public Routine findById(Long id) {
        Optional<Routine> o= routinePersistencePort.findById(id);
        if (o.isPresent()){
            return o.get();
        }
        throw new ExerciseNotFoundException();
    }
}
