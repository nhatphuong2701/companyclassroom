package com.nonit.classroom.service.mapper;

import com.nonit.classroom.entity.Assignment;
import com.nonit.classroom.service.dto.AssignmentDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AssignmentMapper {

    AssignmentMapper INSTANCE = Mappers.getMapper(AssignmentMapper.class);

    @Mapping(target = "classId", source = "clazz.id")
    AssignmentDTO toDto(Assignment assignment);

    List<AssignmentDTO> toDtos(List<Assignment> assignments);

    @Mapping(target = "clazz.id", source = "classId")
    void updateAssignmentFromDTO(AssignmentDTO assignmentDTO, @MappingTarget Assignment assignment);
}
