package com.nonit.classroom.service.mapper;

import com.nonit.classroom.entity.Course;
import com.nonit.classroom.service.dto.CourseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CourseMapper {
    CourseMapper COURSE_MAPPER = Mappers.getMapper(CourseMapper.class);


    CourseDTO toDto(Course course);

    List<CourseDTO> toDtos(List<Course> courses);

}
