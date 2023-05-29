package com.personalproject.companyclassroom.rest.api;

import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.service.dto.creatingDTO.ClassroomCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomUpdatingDTO;
import com.personalproject.companyclassroom.service.dto.customDTO.CustomClassroomDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/api/classrooms")
public interface ClassroomAPI {

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping
    ResponseEntity<List<ClassroomDTO>> getAllClassrooms();

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping
    ResponseEntity<ClassroomDTO> createClassroom(@RequestBody ClassroomCreatingDTO classroomCreatingDTO);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping("/{classroomId}")
    ResponseEntity<ClassroomDTO> updateClassroomById(@PathVariable("classroomId") Long classroomId, @RequestBody ClassroomUpdatingDTO classroomUpdatingDTO);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @DeleteMapping("/{classroomId}")
    void deleteClassroomById(@PathVariable("classroomId") Long classroomId);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/active-classes")
    ResponseEntity<List<CustomClassroomDTO>> findActiveClassesAndNumberOfStudents
            (@RequestParam("role") Role role,
             @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/classroom-from-course")
    ResponseEntity<List<ClassroomDTO>> getClassroomsByCourseId(@RequestParam("courseId") Long courseId);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/end_date")
    ResponseEntity<List<ClassroomDTO>> findByEndDateBefore(@RequestParam("date")
                                                           @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);
}
