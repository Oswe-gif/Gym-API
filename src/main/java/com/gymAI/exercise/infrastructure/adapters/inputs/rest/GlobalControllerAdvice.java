package com.gymAI.exercise.infrastructure.adapters.inputs.rest;

import com.gymAI.exercise.domain.exception.ExerciseNotFoundException;
import com.gymAI.exercise.domain.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.stream.Collectors;

import static com.gymAI.exercise.utils.ErrorCatalog.*;

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)//se envia este codigo como respuesta HTTP
    @ExceptionHandler(ExerciseNotFoundException.class)
    public ErrorResponse handleExerciseNotFoundException(){
        return ErrorResponse.builder()
                .code(EXERCISE_NOT_FOUND.getCode())
                .message(EXERCISE_NOT_FOUND.getMessage())
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)//se envia este codigo como respuesta HTTP
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        return ErrorResponse.builder()
                .code(INVALID_EXERCISE.getCode())
                .message(INVALID_EXERCISE.getMessage())
                .details(result.getFieldErrors().stream().map(fieldError -> fieldError.getDefaultMessage()).collect(Collectors.toList()))
                .timestamp(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handleGenericError(Exception e){
        return ErrorResponse.builder()
                .code(GENERIC_ERROR.getCode())
                .message(GENERIC_ERROR.getMessage())
                .details(Collections.singletonList(e.getMessage()))
                .timestamp(LocalDateTime.now())
                .build();
    }
}
