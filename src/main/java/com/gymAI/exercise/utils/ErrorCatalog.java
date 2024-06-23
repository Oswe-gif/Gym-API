package com.gymAI.exercise.utils;

import lombok.Getter;

@Getter
public enum ErrorCatalog {
    EXERCISE_NOT_FOUND("ERR_EXERCISE_001", "Exercise not found."),
    INVALID_EXERCISE("ERR_EXERCISE_002","Invalid exercise parameters."),
    GENERIC_ERROR("ERR_GEN_001","An unexpected error internal server.");
    private final String code;
    private final String message;
    ErrorCatalog(String code, String message){
        this.code = code;
        this.message = message;
    }
}
