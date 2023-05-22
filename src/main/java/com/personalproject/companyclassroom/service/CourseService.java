package com.personalproject.companyclassroom.service;

import com.personalproject.companyclassroom.service.dto.CourseCreatingDTO;
import com.personalproject.companyclassroom.service.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourses ();

    CourseDTO createCourse(CourseCreatingDTO courseCreatingDTO);

    CourseDTO updateCourse(Long courseId, CourseCreatingDTO courseCreatingDTO);

    void deleteCourse(Long courseId);
}
