package com.gymAI.exercise.infrastructure.adapters.inputs.rest;

import com.gymAI.exercise.application.ports.inputs.ExerciseServicePort;
import com.gymAI.exercise.domain.model.Exercise;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.mapper.ExerciseRestMapper;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.request.ExerciseCreateRequest;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.request.ExerciseUpdateRequest;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.response.ExerciseResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/")
    public ResponseEntity<List<ExerciseResponse>> getAll(){
        List<Exercise> exercises = servicePort.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(restMapper.toExerciseResponseList(exercises));
    }

    @PostMapping("/")
    public ResponseEntity<ExerciseResponse> saveOne(@Valid @RequestBody ExerciseCreateRequest exerciseCreateRequest){
        Exercise exercise = servicePort.save(restMapper.toExercise(exerciseCreateRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(restMapper.toExerciseResponse(exercise));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        servicePort.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ExerciseResponse> updateOne(@Valid @RequestBody ExerciseUpdateRequest exercise, @PathVariable Long id){
        Exercise updatedExercise = servicePort.update(restMapper.fromUpdateRequestToExercise(exercise), id);
        return ResponseEntity.status(HttpStatus.OK).body(restMapper.toExerciseResponse(updatedExercise));
    }
    @GetMapping("/exercises")
    public ResponseEntity<List<ExerciseResponse>> findAllById(@RequestParam List<Long> ids){
        return ResponseEntity.status(HttpStatus.OK).body(restMapper.toExerciseResponseList(servicePort.findAllById(ids)));
    }
}
