package com.nonit.classroom.service.impl;

import com.nonit.classroom.entity.Course;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.CourseRepository;
import com.nonit.classroom.service.CourseService;
import com.nonit.classroom.service.dto.CourseDTO;
import com.nonit.classroom.service.dto.CustomCourseDTO;
import com.nonit.classroom.service.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseDTO> getAllCourses() {
        return CourseMapper.INSTANCE.toDtos(courseRepository.findAll());
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        checkDTO(courseDTO);
        Course course = Course.builder()
                .name(courseDTO.getName())
                .description(courseDTO.getDescription())
                .build();

        return CourseMapper.INSTANCE.toDto(courseRepository.save(course));
    }

    @Override
    public CourseDTO updateCourse(Long courseId, CourseDTO courseDTO) {
        checkDTO(courseDTO);
        Course updatedCourse = courseRepository.findById(courseId).
                orElseThrow(ClassroomException::courseNotFound);
        CourseMapper.INSTANCE.updateCourseFromDTO(courseDTO, updatedCourse);
        return CourseMapper.INSTANCE.toDto(courseRepository.save(updatedCourse));
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<CustomCourseDTO> getCoursesWithNumberOfClassesAndStudents() {
        return courseRepository.findCoursesWithNumberOfClassesAndStudents();
    }

    private static void checkDTO(CourseDTO courseDTO) {
        if (courseDTO.getName().isBlank() || courseDTO.getName() == null) {
            throw ClassroomException.badRequest("InvalidCourseName",
                    "Course name must be filled");
        }
    }
}
