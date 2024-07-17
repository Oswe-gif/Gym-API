package com.gymAI.exercise.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Builder
@Setter
@Getter
public class RoutineCreator {
    private Long id;
    private String title;
    private Long ids_exercises[];
}
