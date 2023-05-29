package com.personalproject.companyclassroom.service;

import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import com.personalproject.companyclassroom.service.dto.creatingDTO.AssignmentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.AssignmentDTO;

import java.util.List;

public interface AssignmentService {

    List<AssignmentDTO> getAllAssignments();

    AssignmentDTO createAssignment(AssignmentCreatingDTO assignmentCreatingDTO);

    AssignmentDTO updateAssignmentById(Long assignmentId, AssignmentCreatingDTO assignmentCreatingDTO);

    void deleteAssignmentById(Long assignmentId);

    List<UserDTO> getStudentHasNoSubmissionByAssignmentId(Long assignmentId);
    List<UserDTO> getStudentHasSubmissionByAssignmentId(Long assignmentId);

}
