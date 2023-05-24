package com.personalproject.companyclassroom.service;

import com.personalproject.companyclassroom.service.dto.AssignmentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.AssignmentDTO;

import java.util.List;

public interface AssignmentService {

    List<AssignmentDTO> getAllAssignments();

    AssignmentDTO createAssignment(AssignmentCreatingDTO assignmentCreatingDTO);

    AssignmentDTO updateAssignmentById(Long assignmentId, AssignmentCreatingDTO assignmentCreatingDTO);

    void deleteAssignmentById(Long assignmentId);
}
