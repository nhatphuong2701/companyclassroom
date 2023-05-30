package com.nonit.classroom.service.impl;

import com.nonit.classroom.entity.Role;
import com.nonit.classroom.service.dto.creatingDTO.CourseCreatingDTO;
import com.nonit.classroom.service.dto.CustomCourseDTO;
import com.nonit.classroom.service.mapper.CourseMapper;
import com.nonit.classroom.entity.Course;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.CourseRepository;
import com.nonit.classroom.service.CourseService;
import com.nonit.classroom.service.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseDTO> getAllCourses() {
        return CourseMapper.COURSE_MAPPER.toDtos(courseRepository.findAll());
    }

    @Override
    public CourseDTO createCourse(CourseCreatingDTO courseCreatingDTO) {
        if(courseCreatingDTO.getName().isBlank() || courseCreatingDTO.getName() == null){
            throw ClassroomException.badRequest("InvalidCourseName",
                    "Course name must be filled");
        }
        Course course = Course.builder()
                .name(courseCreatingDTO.getName())
                .description(courseCreatingDTO.getDescription())
                .build();
        return CourseMapper.COURSE_MAPPER.toDto(courseRepository.save(course));
    }

    @Override
    public CourseDTO updateCourse(Long courseId, CourseCreatingDTO courseCreatingDTO) {
        Course updatedCourse = courseRepository.findById(courseId).
                orElseThrow(ClassroomException::courseNotFound);
        if(courseCreatingDTO.getName() != null)
            updatedCourse.setName(courseCreatingDTO.getName());
        if(courseCreatingDTO.getDescription() != null)
            updatedCourse.setDescription(courseCreatingDTO.getDescription());
        return CourseMapper.COURSE_MAPPER.toDto(courseRepository.save(updatedCourse));
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.findById(courseId).orElseThrow(ClassroomException::courseNotFound);
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<CustomCourseDTO> getCourseWithNumberOfClassesAndStudents(Role studentRole) {
        return courseRepository.getCourseWithNumberOfClassesAndStudents(studentRole);
    }
}
