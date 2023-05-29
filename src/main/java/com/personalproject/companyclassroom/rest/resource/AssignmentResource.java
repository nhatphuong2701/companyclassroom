package com.personalproject.companyclassroom.rest.resource;

import com.personalproject.companyclassroom.rest.api.AssignmentAPI;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import com.personalproject.companyclassroom.service.AssignmentService;
import com.personalproject.companyclassroom.service.dto.creatingDTO.AssignmentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.AssignmentDTO;
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
    public ResponseEntity<AssignmentDTO> createAssignment(AssignmentCreatingDTO assignmentCreatingDTO) {
        AssignmentDTO newAssignment = assignmentService.createAssignment(assignmentCreatingDTO);
        return ResponseEntity.created(URI.create("/api/assignments/" + newAssignment.getId())).body(newAssignment);
    }

    @Override
    public ResponseEntity<AssignmentDTO> updateAssignmentById(Long assignmentId, AssignmentCreatingDTO assignmentCreatingDTO) {
        return ResponseEntity.ok().body(assignmentService.updateAssignmentById(assignmentId,assignmentCreatingDTO));
    }

    @Override
    public void deleteAssignmentById(Long assignmentId) {
        assignmentService.deleteAssignmentById(assignmentId);
        ResponseEntity.noContent().build();
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
