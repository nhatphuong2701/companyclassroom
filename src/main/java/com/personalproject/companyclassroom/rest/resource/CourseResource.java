package com.personalproject.companyclassroom.rest.resource;

import com.personalproject.companyclassroom.rest.api.CourseAPI;
import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.service.CourseService;
import com.personalproject.companyclassroom.service.dto.creatingDTO.CourseCreatingDTO;
import com.personalproject.companyclassroom.service.dto.CourseDTO;
import com.personalproject.companyclassroom.service.dto.customDTO.CustomCourseDTO;
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

    @Override
    public ResponseEntity<List<CustomCourseDTO>> getCourseWithNumberOfClassesAndStudents(Role studentRole) {
        return ResponseEntity.ok(courseService.getCourseWithNumberOfClassesAndStudents(studentRole));
    }
}
