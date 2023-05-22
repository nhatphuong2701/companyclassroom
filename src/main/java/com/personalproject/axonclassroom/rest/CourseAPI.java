package com.personalproject.axonclassroom.rest;

import com.personalproject.axonclassroom.service.dto.CourseCreatingDTO;
import com.personalproject.axonclassroom.service.dto.CourseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/courses")
public interface CourseAPI {
    @GetMapping
    ResponseEntity<List<CourseDTO>> getAllCourses();

    @PostMapping
    ResponseEntity<CourseDTO> createCourse(@RequestBody CourseCreatingDTO courseCreatingDTO);

    @PutMapping("/{courseId}")
    ResponseEntity<CourseDTO> updateCourse( @PathVariable("courseId") Long courseId, @RequestBody CourseCreatingDTO courseCreatingDTO);

    @DeleteMapping("/{courseId}")
    void deleteCourse (@PathVariable("courseId") Long courseId);
}
