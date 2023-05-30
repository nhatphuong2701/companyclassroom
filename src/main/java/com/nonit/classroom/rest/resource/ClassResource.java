package com.nonit.classroom.rest.resource;


import com.nonit.classroom.rest.api.ClassAPI;
import com.nonit.classroom.service.ClassService;
import com.nonit.classroom.service.dto.ClassDTO;
import com.nonit.classroom.service.dto.CustomClassDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
public class ClassResource implements ClassAPI {

    @Autowired
    private ClassService classService;

    @Override
    public ResponseEntity<List<ClassDTO>> getAllClasses() {
        return ResponseEntity.ok(classService.getAllClasses());
    }

    @Override
    public ResponseEntity<ClassDTO> createClass(ClassDTO classDTO) {
        ClassDTO newClassroom = classService.createClass(classDTO);
        return ResponseEntity.created(URI.create("/api/classrooms/" + newClassroom.getId())).body(newClassroom);
    }

    @Override
    public ResponseEntity<ClassDTO> updateClass(Long classId, ClassDTO classDTO) {
        return ResponseEntity.ok().body(classService.updateClass(classId, classDTO));
    }

    @Override
    public ResponseEntity<Void> deleteClass(Long classId) {
        classService.deleteClass(classId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<CustomClassDTO>> getActiveClassesAndNumberOfStudents(LocalDate date) {
        return ResponseEntity.ok(classService.getActiveClassesAndNumberOfStudents(date));
    }

    @Override
    public ResponseEntity<List<ClassDTO>> getClassesByCourseId(Long courseId) {
        return ResponseEntity.ok(classService.getClassesByCourseId(courseId));
    }

    @Override
    public ResponseEntity<List<ClassDTO>> getClassesByEndDateBefore(LocalDate date) {
        return ResponseEntity.ok(classService.getByEndDateBefore(date));
    }
}
