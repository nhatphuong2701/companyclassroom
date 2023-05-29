package com.personalproject.companyclassroom.rest.api;

import com.personalproject.companyclassroom.service.dto.creatingDTO.AssignmentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.AssignmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/assignments")
public interface AssignmentAPI {

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping
    ResponseEntity<List<AssignmentDTO>> getAllAssignments();

    @PreAuthorize(value = "hasAnyRole('TEACHER','ADMIN')")
    @PostMapping
    ResponseEntity<AssignmentDTO> createAssignment(@RequestBody AssignmentCreatingDTO assignmentCreatingDTO);

    @PreAuthorize(value = "hasAnyRole('TEACHER','ADMIN')")
    @PutMapping("/{assignmentId}")
    ResponseEntity<AssignmentDTO> updateAssignmentById(@PathVariable("assignmentId") Long assignmentId, AssignmentCreatingDTO assignmentCreatingDTO);

    @PreAuthorize(value = "hasAnyRole('TEACHER','ADMIN')")
    @DeleteMapping("/{assignmentId}")
    void deleteAssignmentById(@PathVariable("assignmentId") Long assignmentId);
}
