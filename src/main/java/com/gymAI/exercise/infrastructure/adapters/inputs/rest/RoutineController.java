package com.gymAI.exercise.infrastructure.adapters.inputs.rest;

import com.gymAI.exercise.application.ports.inputs.RoutineServicePort;
import com.gymAI.exercise.domain.model.Routine;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.mapper.RoutineRestMapper;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.request.RoutineCreateRequest;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.response.RoutineResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RoutineController {
    RoutineServicePort servicePort;
    RoutineRestMapper mapper;

    @GetMapping("routines/")
    public ResponseEntity<List<RoutineResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toRoutineResponseList(servicePort.getAll()));
    }
    @GetMapping("routines/{id}")
    public ResponseEntity<RoutineResponse> getOneExercise(@PathVariable Long id){
        Routine routine= servicePort.findById(id);
        return ResponseEntity.ok(mapper.toRoutineResponse(routine));
    }

    @PostMapping("routines/")
    public ResponseEntity<RoutineResponse> saveOne(@Valid @RequestBody RoutineCreateRequest routineCreateRequest){
        System.out.println(routineCreateRequest.getIds_exercises());
        Routine routine = servicePort.save(mapper.toRoutineCreator(routineCreateRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toRoutineResponse(routine));
    }

}
