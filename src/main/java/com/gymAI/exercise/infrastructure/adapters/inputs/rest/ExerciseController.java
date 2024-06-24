package com.gymAI.exercise.infrastructure.adapters.inputs.rest;

import com.gymAI.exercise.application.ports.inputs.ExerciseServicePort;
import com.gymAI.exercise.domain.model.Exercise;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.mapper.ExerciseRestMapper;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.request.ExerciseCreateRequest;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.response.ExerciseResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/")
    public ResponseEntity<ExerciseResponse> saveOne(@Valid @RequestBody ExerciseCreateRequest exerciseCreateRequest){
        Exercise exercise = servicePort.save(restMapper.toExercise(exerciseCreateRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(restMapper.toExerciseResponse(exercise));
    }
}
