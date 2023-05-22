package com.personalproject.companyclassroom.service.impl;

import com.personalproject.companyclassroom.entity.Course;
import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.repository.CourseRepository;
import com.personalproject.companyclassroom.service.CourseService;
import com.personalproject.companyclassroom.service.dto.CourseCreatingDTO;
import com.personalproject.companyclassroom.service.dto.CourseDTO;
import com.personalproject.companyclassroom.service.mapper.CourseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    @Override
    public List<CourseDTO> getAllCourses() {
        return CourseMapper.COURSE_MAPPER.toDtos(courseRepository.findAll());
    }

    @Override
    public CourseDTO createCourse(CourseCreatingDTO courseCreatingDTO) {
        Course course = Course.builder()
                .name(courseCreatingDTO.getName())
                .description(courseCreatingDTO.getDescription())
                .build();
        return CourseMapper.COURSE_MAPPER.toDto(courseRepository.save(course));
    }

    @Override
    public CourseDTO updateCourse(Long courseId, CourseCreatingDTO courseCreatingDTO) {
        Course updatedCourse = courseRepository.findById(courseId).orElseThrow(CompanyClassroomException::entityNotFound);
        updatedCourse.setName(courseCreatingDTO.getName());
        updatedCourse.setDescription(courseCreatingDTO.getDescription());
        return CourseMapper.COURSE_MAPPER.toDto(courseRepository.save(updatedCourse));
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.findById(courseId).orElseThrow(CompanyClassroomException::entityNotFound);
        courseRepository.deleteById(courseId);
    }
}
