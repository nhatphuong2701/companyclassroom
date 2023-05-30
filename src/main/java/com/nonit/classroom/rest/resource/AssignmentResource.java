package com.nonit.classroom.rest.resource;

import com.nonit.classroom.rest.api.AssignmentAPI;
import com.nonit.classroom.service.AssignmentService;
import com.nonit.classroom.service.dto.AssignmentDTO;
import com.nonit.classroom.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class AssignmentResource implements AssignmentAPI {

    @Autowired
    private AssignmentService assignmentService;

    @Override
    public ResponseEntity<List<AssignmentDTO>> getAllAssignments() {
        return ResponseEntity.ok(assignmentService.getAllAssignments());
    }

    @Override
    public ResponseEntity<AssignmentDTO> createAssignment(AssignmentDTO assignmentDTO) {
        AssignmentDTO newAssignment = assignmentService.createAssignment(assignmentDTO);
        return ResponseEntity.created(URI.create("/api/assignments/" + newAssignment.getId())).body(newAssignment);
    }

    @Override
    public ResponseEntity<AssignmentDTO> updateAssignment(Long assignmentId, AssignmentDTO assignmentDTO) {
        return ResponseEntity.ok().body(assignmentService.updateAssignment(assignmentId, assignmentDTO));
    }

    @Override
    public ResponseEntity<Void> deleteAssignment(Long assignmentId) {
        assignmentService.deleteAssignment(assignmentId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<UserDTO>> getStudentHasNoSubmissionByAssignmentId(Long assignmentId) {
        return ResponseEntity.ok(assignmentService.getStudentHasNoSubmissionByAssignmentId(assignmentId));
    }

    @Override
    public ResponseEntity<List<UserDTO>> getStudentHasSubmissionByAssignmentId(Long assignmentId) {
        return ResponseEntity.ok(assignmentService.getStudentHasSubmissionByAssignmentId(assignmentId));
    }
}
