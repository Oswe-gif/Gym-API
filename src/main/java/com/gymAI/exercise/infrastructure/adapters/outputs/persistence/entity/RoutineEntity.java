package com.gymAI.exercise.infrastructure.adapters.outputs.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@Entity
@Table(name="routines")
public class RoutineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "exercise_routine",
            joinColumns = @JoinColumn(name = "routine_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<ExerciseEntity> exercises;
    @NotBlank
    private String title;

    /*@Override
    public String toString() {
        return "RoutineEntity{" +
                "exercises=" + exercises +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }*/
}
