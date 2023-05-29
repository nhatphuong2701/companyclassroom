package com.personalproject.companyclassroom.service;

import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.service.dto.creatingDTO.CourseCreatingDTO;
import com.personalproject.companyclassroom.service.dto.CourseDTO;
import com.personalproject.companyclassroom.service.dto.customDTO.CustomCourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> getAllCourses ();

    CourseDTO createCourse(CourseCreatingDTO courseCreatingDTO);

    CourseDTO updateCourse(Long courseId, CourseCreatingDTO courseCreatingDTO);

    void deleteCourse(Long courseId);

    List<CustomCourseDTO> getCourseWithNumberOfClassesAndStudents(Role role);
}
