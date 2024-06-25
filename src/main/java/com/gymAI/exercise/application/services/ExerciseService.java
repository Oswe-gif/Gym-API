package com.gymAI.exercise.application.services;

import com.gymAI.exercise.application.ports.inputs.ExerciseServicePort;
import com.gymAI.exercise.application.ports.outputs.ExercisePersistencePort;
import com.gymAI.exercise.domain.exception.ExerciseNotFoundException;
import com.gymAI.exercise.domain.model.Exercise;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExerciseService implements ExerciseServicePort {
    @Autowired
    private ExercisePersistencePort exercisePersistencePort;

    @Override
    public Exercise findById(Long id) {
        //el orElseThrow me desenvuelve el objeto Optional y si obtiene un null ps salta una exception. En otro caso, desvuelve el objeto ya interno (el generico) del Optional
        //return exercisePersistencePort.findById(id).orElseThrow(()-> new ExerciseNotFoundException());
        Optional<Exercise> o= exercisePersistencePort.findById(id);
        if (o.isPresent()){
            return o.get();
        }
        throw new ExerciseNotFoundException();

    }

    @Override
    public List<Exercise> getAll() {
        List<Exercise> exercises = exercisePersistencePort.getAll();
        if (!exercises.isEmpty()){
            return exercises;
        }
        throw new ExerciseNotFoundException();
    }

    @Override
    public Exercise save(Exercise exercise) {
        return exercisePersistencePort.save(exercise);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Exercise> o = exercisePersistencePort.findById(id);
        if (!o.isPresent()){
            throw new ExerciseNotFoundException();
        }
        exercisePersistencePort.deleteById(id);

    }

    @Override
    public Exercise update(Exercise exercise,Long id) {
        Optional<Exercise> o = exercisePersistencePort.findById(id);
        if (!o.isPresent()){
            throw new ExerciseNotFoundException();
        }
        if (!(exercise.getTitle() == null)){
            o.get().setTitle(exercise.getTitle());
        }
        if (!(exercise.getDetails() == null)){
            o.get().setDetails(exercise.getDetails());
        }
        return exercisePersistencePort.save(o.get());
    }
}
