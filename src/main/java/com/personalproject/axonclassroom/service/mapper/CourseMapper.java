package com.personalproject.axonclassroom.service.mapper;

import com.personalproject.axonclassroom.entity.Course;
import com.personalproject.axonclassroom.service.dto.CourseDTO;
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
