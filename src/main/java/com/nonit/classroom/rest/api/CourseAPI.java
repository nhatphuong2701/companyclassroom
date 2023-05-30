package com.nonit.classroom.rest.api;

import com.nonit.classroom.service.dto.CourseDTO;
import com.nonit.classroom.service.dto.CustomCourseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nonit.classroom.constant.AuthorityConstants.HAS_ANY_ROLE;
import static com.nonit.classroom.constant.AuthorityConstants.HAS_ROLE_ADMIN;

@RequestMapping("/api/courses")
public interface CourseAPI {

    @PreAuthorize(HAS_ANY_ROLE)
    @GetMapping
    ResponseEntity<List<CourseDTO>> getAllCourses();

    @PreAuthorize(HAS_ROLE_ADMIN)
    @PostMapping
    ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO);


    @PreAuthorize(HAS_ROLE_ADMIN)
    @PutMapping("/{courseId}")
    ResponseEntity<CourseDTO> updateCourse(@PathVariable Long courseId, @RequestBody CourseDTO courseDTO);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @DeleteMapping("/{courseId}")
    ResponseEntity<Void> deleteCourse(@PathVariable Long courseId);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @GetMapping("/classes-and-students")
    ResponseEntity<List<CustomCourseDTO>> getCoursesWithNumberOfClassesAndStudents();
}
