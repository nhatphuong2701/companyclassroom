package com.personalproject.axonclassroom.rest;

import com.personalproject.axonclassroom.entity.Teacher;
import com.personalproject.axonclassroom.service.TeacherService;
import com.personalproject.axonclassroom.service.dto.TeacherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherResource implements TeacherAPI{
    private final TeacherService teacherService;
    @Override
    public ResponseEntity<List<TeacherDTO>> getAllTeachers() {
        return ResponseEntity.ok(teacherService.getAllTeachers());
    }

    @Override
    public ResponseEntity<Teacher> createTeacher(Long teacherId, TeacherDTO teacherDTO) {
        return ResponseEntity.ok(teacherService.createTeacher(teacherId, teacherDTO));
    }
}
