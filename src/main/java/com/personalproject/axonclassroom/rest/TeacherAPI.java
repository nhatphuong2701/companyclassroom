package com.personalproject.axonclassroom.rest;

import com.personalproject.axonclassroom.entity.Teacher;
import com.personalproject.axonclassroom.service.dto.TeacherCreatingDTO;
import com.personalproject.axonclassroom.service.dto.TeacherDTO;
import com.personalproject.axonclassroom.service.dto.TeacherUpdatingDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/teachers")
public interface TeacherAPI {
    @GetMapping
    ResponseEntity<List<TeacherDTO>> getAllTeachers();

    @PostMapping
    ResponseEntity<TeacherDTO> createTeacher(@RequestBody TeacherCreatingDTO teacherCreatingDTO);

    @PutMapping("/{teacherId}")
    ResponseEntity<TeacherDTO> updateTeacherById(@PathVariable("teacherId") Long teacherId, @RequestBody TeacherUpdatingDTO teacherUpdatingDTO);

    @DeleteMapping("/{teacherId}")
    void deleteTeacherById(@PathVariable("teacherId") Long id);

    @GetMapping("/{teacherId}")
    ResponseEntity<TeacherDTO> getTeacherById(@PathVariable("teacherId") Long teacherId);

    @GetMapping("/username")
    ResponseEntity<List<TeacherDTO>> getTeacherByUsername(@RequestParam("username") String username);
}
