package com.personalproject.companyclassroom.rest;

import com.personalproject.companyclassroom.service.ClassroomService;
import com.personalproject.companyclassroom.service.dto.ClassroomCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClassroomResource implements ClassroomAPI{

    private final ClassroomService classroomService;

    @Override
    public ResponseEntity<List<ClassroomDTO>> getAllClassrooms() {
        return ResponseEntity.ok(classroomService.getAllClassrooms());
    }

    @Override
    public ResponseEntity<ClassroomDTO> createClassroom(ClassroomCreatingDTO classroomCreatingDTO) {
        return ResponseEntity.ok(classroomService.createClassroom(classroomCreatingDTO));
    }

    @Override
    public ResponseEntity<ClassroomDTO> updateClassroomById(Long classroomId, ClassroomCreatingDTO classroomCreatingDTO) {
        return ResponseEntity.ok().body(classroomService.updateClassroomById(classroomId, classroomCreatingDTO));
    }

    @Override
    public void deleteClassroomById(Long classroomId) {
        classroomService.deleteClassroomByID(classroomId);
        ResponseEntity.noContent().build();
    }
}
