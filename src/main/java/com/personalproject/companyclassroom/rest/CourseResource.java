package com.personalproject.companyclassroom.rest;

import com.personalproject.companyclassroom.service.CourseService;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.CourseCreatingDTO;
import com.personalproject.companyclassroom.service.dto.CourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseResource implements CourseAPI{

    private final CourseService courseService;
    @Override
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @Override
    public ResponseEntity<CourseDTO> createCourse(CourseCreatingDTO courseCreatingDTO) {
        CourseDTO newCourse = courseService.createCourse(courseCreatingDTO);
        return ResponseEntity.created(URI.create("/api/courses/" + newCourse.getId())).body(newCourse);
    }

    @Override
    public ResponseEntity<CourseDTO> updateCourse(Long courseId, CourseCreatingDTO courseCreatingDTO) {
        return ResponseEntity.ok().body(courseService.updateCourse(courseId, courseCreatingDTO));
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseService.deleteCourse(courseId);
        ResponseEntity.noContent().build();
    }
}
