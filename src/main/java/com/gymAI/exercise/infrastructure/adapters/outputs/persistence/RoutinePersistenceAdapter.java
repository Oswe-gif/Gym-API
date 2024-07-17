package com.gymAI.exercise.infrastructure.adapters.outputs.persistence;

import com.gymAI.exercise.application.ports.outputs.RoutinePersistencePort;
import com.gymAI.exercise.domain.model.Exercise;
import com.gymAI.exercise.domain.model.Routine;
import com.gymAI.exercise.domain.model.RoutineCreator;
import com.gymAI.exercise.infrastructure.adapters.outputs.persistence.mapper.RoutinePersistenceMapper;
import com.gymAI.exercise.infrastructure.adapters.outputs.persistence.repository.RoutineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class RoutinePersistenceAdapter implements RoutinePersistencePort {
    RoutineRepository routineRepository;
    RoutinePersistenceMapper mapper;
    @Override
    public List<Routine> getAll() {
        return mapper.toRoutineList(routineRepository.findAll());
    }

    @Override
    public Routine save(Routine routine) {
        return mapper.toRoutine(routineRepository.save(mapper.toRoutineEntity(routine)));
    }

    @Override
    public Optional<Routine> findById(Long id) {

        return routineRepository.findById(id).map((routineEntity)->
                mapper.toRoutine(routineEntity)
        );
    }
}
