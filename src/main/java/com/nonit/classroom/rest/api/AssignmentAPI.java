package com.nonit.classroom.rest.api;

import com.nonit.classroom.service.dto.AssignmentDTO;
import com.nonit.classroom.service.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nonit.classroom.constant.AuthorityConstants.HAS_ROLE_ADMIN;
import static com.nonit.classroom.constant.AuthorityConstants.HAS_ROLE_TEACHER_ADMIN;

@RequestMapping("/api/assignments")
public interface AssignmentAPI {

    @PreAuthorize(HAS_ROLE_ADMIN)
    @GetMapping
    ResponseEntity<List<AssignmentDTO>> getAllAssignments();

    @PreAuthorize(HAS_ROLE_TEACHER_ADMIN)
    @PostMapping
    ResponseEntity<AssignmentDTO> createAssignment(@RequestBody AssignmentDTO assignmentDTO);

    @PreAuthorize(HAS_ROLE_TEACHER_ADMIN)
    @PutMapping("/{assignmentId}")
    ResponseEntity<AssignmentDTO> updateAssignment(@PathVariable Long assignmentId,
                                                       @RequestBody AssignmentDTO assignmentDTO);

    @PreAuthorize(HAS_ROLE_TEACHER_ADMIN)
    @DeleteMapping("/{assignmentId}")
    ResponseEntity<Void> deleteAssignment(@PathVariable Long assignmentId);

    @PreAuthorize(HAS_ROLE_TEACHER_ADMIN)
    @GetMapping("/student-has-no-submission")
    ResponseEntity<List<UserDTO>> getStudentHasNoSubmissionByAssignmentId(@RequestParam Long assignmentId);

    @PreAuthorize(HAS_ROLE_TEACHER_ADMIN)
    @GetMapping("/student-has-submission")
    ResponseEntity<List<UserDTO>> getStudentHasSubmissionByAssignmentId(@RequestParam Long assignmentId);
}
