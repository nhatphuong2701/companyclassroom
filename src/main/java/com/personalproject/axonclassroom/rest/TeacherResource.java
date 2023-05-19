package com.personalproject.axonclassroom.rest;

import com.personalproject.axonclassroom.service.TeacherService;
import com.personalproject.axonclassroom.service.dto.TeacherCreatingDTO;
import com.personalproject.axonclassroom.service.dto.TeacherDTO;
import com.personalproject.axonclassroom.service.dto.TeacherUpdatingDTO;
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
    public ResponseEntity<TeacherDTO> createTeacher(TeacherCreatingDTO teacherCreatingDTO) {
        return ResponseEntity.ok(teacherService.createTeacher(teacherCreatingDTO));
    }

    @Override
    public ResponseEntity<TeacherDTO> updateTeacherById(Long teacherId, TeacherUpdatingDTO teacherUpdatingDTO) {
        return ResponseEntity.ok(teacherService.updateTeacherById(teacherId, teacherUpdatingDTO));
    }
}
