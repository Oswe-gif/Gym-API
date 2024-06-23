package com.gymAI.exercise.infrastructure.adapters.outputs.persistence.repository;

import com.gymAI.exercise.infrastructure.adapters.outputs.persistence.entity.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {

}
