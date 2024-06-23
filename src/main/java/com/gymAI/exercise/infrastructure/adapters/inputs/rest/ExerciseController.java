package com.gymAI.exercise.infrastructure.adapters.inputs.rest;

import com.gymAI.exercise.application.ports.inputs.ExerciseServicePort;
import com.gymAI.exercise.domain.model.Exercise;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.mapper.ExerciseRestMapper;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.response.ExerciseResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
public class ExerciseController {

    private ExerciseServicePort servicePort;

    private ExerciseRestMapper restMapper;

    @GetMapping("/{id}")
    public ResponseEntity<ExerciseResponse> getOneExercise(@PathVariable Long id){
        Exercise exercise= servicePort.findById(id);
        return ResponseEntity.ok(restMapper.toExerciseResponse(exercise));
    }
}
