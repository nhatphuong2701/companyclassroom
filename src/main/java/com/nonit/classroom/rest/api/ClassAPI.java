package com.nonit.classroom.rest.api;

import com.nonit.classroom.service.dto.ClassDTO;
import com.nonit.classroom.service.dto.CustomClassDTO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static com.nonit.classroom.constant.AuthorityConstants.HAS_ROLE_ADMIN;

@RequestMapping("/api/classes")
public interface ClassAPI {

    @PreAuthorize(HAS_ROLE_ADMIN)
    @GetMapping
    ResponseEntity<List<ClassDTO>> getAllClasses();

    @PreAuthorize(HAS_ROLE_ADMIN)
    @PostMapping
    ResponseEntity<ClassDTO> createClass(@RequestBody ClassDTO classDTO);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @PutMapping("/{classroomId}")
    ResponseEntity<ClassDTO> updateClass(@PathVariable Long classId, @RequestBody ClassDTO classDTO);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @DeleteMapping("/{classroomId}")
    ResponseEntity<Void> deleteClass(@PathVariable Long classroomId);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @GetMapping("/active-classes")
    ResponseEntity<List<CustomClassDTO>> getActiveClassesAndNumberOfStudents
            (@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @GetMapping("/class-from-course")
    ResponseEntity<List<ClassDTO>> getClassesByCourseId(@RequestParam Long courseId);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @GetMapping("/end_date")
    ResponseEntity<List<ClassDTO>> getClassesByEndDateBefore
            (@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date);
}
