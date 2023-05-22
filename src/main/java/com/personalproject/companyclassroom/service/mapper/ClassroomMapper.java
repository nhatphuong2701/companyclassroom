package com.personalproject.companyclassroom.service.mapper;

import com.personalproject.companyclassroom.entity.Classroom;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClassroomMapper {
    ClassroomMapper CLASSROOM_MAPPER = Mappers.getMapper(ClassroomMapper.class);

    ClassroomDTO toDto (Classroom classroom);

    List<ClassroomDTO> toDtos (List<Classroom> classrooms);
}
