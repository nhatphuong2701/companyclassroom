package com.nonit.classroom.service;

import com.nonit.classroom.service.dto.CourseDTO;
import com.nonit.classroom.service.dto.CustomCourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourses();

    CourseDTO createCourse(CourseDTO courseDTO);

    CourseDTO updateCourse(Long courseId, CourseDTO courseDTO);

    void deleteCourse(Long courseId);

    List<CustomCourseDTO> getCoursesWithNumberOfClassesAndStudents();
}
