package com.gymAI.exercise.infrastructure.adapters.outputs.persistence.mapper;

import com.gymAI.exercise.domain.model.Routine;
import com.gymAI.exercise.domain.model.RoutineCreator;
import com.gymAI.exercise.infrastructure.adapters.outputs.persistence.entity.RoutineEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoutinePersistenceMapper {
    List<Routine> toRoutineList(List<RoutineEntity> routineEntityList);
    RoutineEntity toRoutineEntity(Routine routine);
    Routine toRoutine(RoutineEntity routine);
    RoutineCreator toRoutineCreator(RoutineEntity routine);

}
