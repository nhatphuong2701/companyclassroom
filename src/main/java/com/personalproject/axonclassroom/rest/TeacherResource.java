package com.personalproject.axonclassroom.rest;

import com.personalproject.axonclassroom.exception.AxonClassroomException;
import com.personalproject.axonclassroom.exception.ResponseException;
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
            return ResponseEntity.ok().body(teacherService.updateTeacherById(teacherId, teacherUpdatingDTO));
    }

    @Override
    public void deleteTeacherById(Long id) {
           teacherService.deleteTeacherById(id);
           ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<TeacherDTO> getTeacherById(Long teacherId) {
        return ResponseEntity.ok(teacherService.getTeacherById(teacherId));
    }

    @Override
    public ResponseEntity<List<TeacherDTO>> getTeacherByUsername(String username){
        try{
            return ResponseEntity.ok(teacherService.getTeacherByUserName(username));
        } catch (ResponseException ex) {
            throw AxonClassroomException.badRequest("USERNAME_DOES_NOT_EXIST", "Username does not exist");
        }
    }
}
