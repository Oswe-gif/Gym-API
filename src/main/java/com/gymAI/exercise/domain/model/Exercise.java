package com.gymAI.exercise.domain.model;

import lombok.*;

@Builder
@Setter
@Getter
public class Exercise {
    //un objeto POJO
    private Long id;
    private String title;
    private String details;
}
