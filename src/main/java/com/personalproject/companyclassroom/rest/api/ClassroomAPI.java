package com.personalproject.companyclassroom.rest.api;

import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.service.dto.creatingDTO.ClassroomCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomUpdatingDTO;
import com.personalproject.companyclassroom.service.dto.customDTO.CustomClassroomDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/active-classes")
    ResponseEntity<List<CustomClassroomDTO>> findActiveClassesAndNumberOfStudents
            (@RequestParam("role") Role role,
             @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @GetMapping("/classroom-from-course")
    ResponseEntity<List<ClassroomDTO>> getClassroomsByCourseId(@Param("courseId") Long courseId);
}
