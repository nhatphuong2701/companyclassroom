package com.personalproject.companyclassroom.rest.resource;


import com.personalproject.companyclassroom.rest.api.ClassroomAPI;
import com.personalproject.companyclassroom.service.ClassroomService;
import com.personalproject.companyclassroom.service.dto.creatingDTO.ClassroomCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomUpdatingDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class ClassroomResource implements ClassroomAPI {

    private final ClassroomService classroomService;

    @Override
    public ResponseEntity<List<ClassroomDTO>> getAllClassrooms() {
        return ResponseEntity.ok(classroomService.getAllClassrooms());
    }

    @Override
    public ResponseEntity<ClassroomDTO> createClassroom(ClassroomCreatingDTO classroomCreatingDTO) {
        ClassroomDTO newClassroom = classroomService.createClassroom(classroomCreatingDTO);
        return ResponseEntity.created(URI.create("/api/classrooms/" + newClassroom.getId())).body(newClassroom);
    }

    @Override
    public ResponseEntity<ClassroomDTO> updateClassroomById(Long classroomId, ClassroomUpdatingDTO classroomUpdatingDTO) {
        return ResponseEntity.ok().body(classroomService.updateClassroomById(classroomId, classroomUpdatingDTO));
    }

    @Override
    public void deleteClassroomById(Long classroomId) {
        classroomService.deleteClassroomById(classroomId);
        ResponseEntity.noContent().build();
    }
}
