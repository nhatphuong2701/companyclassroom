package com.personalproject.companyclassroom.rest;

import com.personalproject.companyclassroom.service.dto.ClassroomCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomUpdatingDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/classrooms")
public interface ClassroomAPI {
    @GetMapping
    ResponseEntity<List<ClassroomDTO>> getAllClassrooms();

    @PostMapping
    ResponseEntity<ClassroomDTO> createClassroom(@RequestBody ClassroomCreatingDTO classroomCreatingDTO);

    @PutMapping("/{classroomId}")
    ResponseEntity<ClassroomDTO> updateClassroomById(@PathVariable("classroomId") Long classroomId, @RequestBody ClassroomUpdatingDTO classroomUpdatingDTO);

    @DeleteMapping("/{classroomId}")
    void deleteClassroomById(@PathVariable("classroomId") Long classroomId);
}
