package com.gymAI.exercise.infrastructure.adapters.inputs.rest.mapper;

import com.gymAI.exercise.domain.model.Routine;
import com.gymAI.exercise.domain.model.RoutineCreator;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.request.RoutineCreateRequest;
import com.gymAI.exercise.infrastructure.adapters.inputs.rest.model.response.RoutineResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoutineRestMapper {
    Routine toRoutine(RoutineCreateRequest routineCreateRequest);
    RoutineCreator toRoutineCreator(RoutineCreateRequest routineCreateRequest);
    RoutineResponse toRoutineResponse(Routine routine);
    List<RoutineResponse> toRoutineResponseList(List<Routine> routines);

}
