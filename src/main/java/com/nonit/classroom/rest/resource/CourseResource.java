package com.nonit.classroom.rest.resource;

import com.nonit.classroom.rest.api.CourseAPI;
import com.nonit.classroom.service.CourseService;
import com.nonit.classroom.service.dto.CourseDTO;
import com.nonit.classroom.service.dto.CustomCourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class CourseResource implements CourseAPI {

    @Autowired
    private CourseService courseService;

    @Override
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @Override
    public ResponseEntity<CourseDTO> createCourse(CourseDTO courseDTO) {
        CourseDTO newCourse = courseService.createCourse(courseDTO);
        return ResponseEntity.created(URI.create("/api/courses/" + newCourse.getId())).body(newCourse);
    }

    @Override
    public ResponseEntity<CourseDTO> updateCourse(Long courseId, CourseDTO courseDTO) {
        return ResponseEntity.ok().body(courseService.updateCourse(courseId, courseDTO));
    }

    @Override
    public ResponseEntity<Void> deleteCourse(Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<CustomCourseDTO>> getCoursesWithNumberOfClassesAndStudents() {
        return ResponseEntity.ok(courseService.getCoursesWithNumberOfClassesAndStudents());
    }
}
