package com.personalproject.companyclassroom.rest.api;

import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.service.dto.creatingDTO.CourseCreatingDTO;
import com.personalproject.companyclassroom.service.dto.CourseDTO;
import com.personalproject.companyclassroom.service.dto.customDTO.CustomCourseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/courses")
public interface CourseAPI {

    @PreAuthorize(value = "hasAnyRole('ADMIN','TEACHER','STUDENT')")
    @GetMapping
    ResponseEntity<List<CourseDTO>> getAllCourses();

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping
    ResponseEntity<CourseDTO> createCourse(@RequestBody CourseCreatingDTO courseCreatingDTO);


    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping("/{courseId}")
    ResponseEntity<CourseDTO> updateCourse( @PathVariable("courseId") Long courseId, @RequestBody CourseCreatingDTO courseCreatingDTO);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @DeleteMapping("/{courseId}")
    void deleteCourse (@PathVariable("courseId") Long courseId);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/classes-and-students")
    ResponseEntity<List<CustomCourseDTO>> getCourseWithNumberOfClassesAndStudents(@RequestParam("studentRole") Role studentRole);
}
