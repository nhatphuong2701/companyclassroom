package com.nonit.classroom.service.mapper;

import com.nonit.classroom.entity.Clazz;
import com.nonit.classroom.service.dto.ClassDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ClassMapper {

    ClassMapper INSTANCE = Mappers.getMapper(ClassMapper.class);

    @Mapping(target = "courseId", source = "course.id")
    ClassDTO toDto(Clazz clazz);

    List<ClassDTO> toDtos(List<Clazz> clazzes);

    @Mapping(target = "course.id", source = "courseId")
    void updateClassFromDTO(ClassDTO classDTO, @MappingTarget Clazz clazz);
}
