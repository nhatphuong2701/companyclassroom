package com.personalproject.axonclassroom.service;

import com.personalproject.axonclassroom.service.dto.CourseCreatingDTO;
import com.personalproject.axonclassroom.service.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourses ();

    CourseDTO createCourse(CourseCreatingDTO courseCreatingDTO);

    CourseDTO updateCourse(Long courseId, CourseCreatingDTO courseCreatingDTO);

    void deleteCourse(Long courseId);
}
