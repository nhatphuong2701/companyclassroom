package com.personalproject.axonclassroom.service.mapper;

import com.personalproject.axonclassroom.entity.Teacher;
import com.personalproject.axonclassroom.service.dto.TeacherDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeacherMapper {
    TeacherMapper TEACHER_MAPPER = Mappers.getMapper(TeacherMapper.class);

    TeacherDTO toDto (Teacher teacher);

    List<TeacherDTO> toDtos (List<Teacher> teachers);
}
