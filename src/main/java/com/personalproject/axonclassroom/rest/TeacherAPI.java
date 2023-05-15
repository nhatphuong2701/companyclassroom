package com.personalproject.axonclassroom.rest;

import com.personalproject.axonclassroom.entity.Teacher;
import com.personalproject.axonclassroom.service.dto.TeacherDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/teachers")
public interface TeacherAPI {
    @GetMapping
    ResponseEntity<List<TeacherDTO>> getAllTeachers();

    @PostMapping("/teachers/{teacherId}")
    ResponseEntity<Teacher> createTeacher(@PathVariable("teacherId") Long teacherId, @RequestBody TeacherDTO teacherDTO);

}
