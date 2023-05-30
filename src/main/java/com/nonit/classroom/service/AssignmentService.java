package com.nonit.classroom.service;

import com.nonit.classroom.service.dto.AssignmentDTO;
import com.nonit.classroom.service.dto.UserDTO;

import java.util.List;

public interface AssignmentService {

    List<AssignmentDTO> getAllAssignments();

    AssignmentDTO createAssignment(AssignmentDTO assignmentDTO);

    AssignmentDTO updateAssignment(Long assignmentId, AssignmentDTO assignmentCreatingDTO);

    void deleteAssignment(Long assignmentId);

    List<UserDTO> getStudentHasNoSubmissionByAssignmentId(Long assignmentId);

    List<UserDTO> getStudentHasSubmissionByAssignmentId(Long assignmentId);
}
