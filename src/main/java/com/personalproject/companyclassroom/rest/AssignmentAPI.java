package com.personalproject.companyclassroom.rest;

import com.personalproject.companyclassroom.service.dto.AssignmentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.AssignmentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/assignments")
public interface AssignmentAPI {
    @GetMapping
    ResponseEntity<List<AssignmentDTO>> getAllAssignments();

    @PostMapping
    ResponseEntity<AssignmentDTO> createAssignment(@RequestBody AssignmentCreatingDTO assignmentCreatingDTO);

    @PutMapping("/{assignmentId}")
    ResponseEntity<AssignmentDTO> updateAssignmentById(@PathVariable("assignmentId") Long assignmentId, AssignmentCreatingDTO assignmentCreatingDTO);

    @DeleteMapping("/{assignmentId}")
    void deleteAssignmentById(@PathVariable("assignmentId") Long assignmentId);
}
