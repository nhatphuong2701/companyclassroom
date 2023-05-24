package com.personalproject.companyclassroom.rest;

import com.personalproject.companyclassroom.service.AssignmentService;
import com.personalproject.companyclassroom.service.dto.AssignmentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.AssignmentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AssignmentResource implements AssignmentAPI{

    private final AssignmentService assignmentService;

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
}
