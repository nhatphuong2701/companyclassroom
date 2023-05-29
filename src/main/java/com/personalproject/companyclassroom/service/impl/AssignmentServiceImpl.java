package com.personalproject.companyclassroom.service.impl;

import com.personalproject.companyclassroom.entity.Assignment;
import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.repository.AssignmentRepository;
import com.personalproject.companyclassroom.repository.ClassroomRepository;
import com.personalproject.companyclassroom.security.entity.User;
import com.personalproject.companyclassroom.security.repository.UserRepository;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import com.personalproject.companyclassroom.security.service.mapper.UserMapper;
import com.personalproject.companyclassroom.service.AssignmentService;
import com.personalproject.companyclassroom.service.dto.creatingDTO.AssignmentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.AssignmentDTO;
import com.personalproject.companyclassroom.service.mapper.AssignmentMapper;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class AssignmentServiceImpl implements AssignmentService {
    Logger logger = LoggerFactory.getLogger(AssignmentService.class);

    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AssignmentDTO> getAllAssignments() {
        return AssignmentMapper.ASSIGNMENT_MAPPER.toDtos(assignmentRepository.findAll());
    }

    @Override
    public AssignmentDTO createAssignment(AssignmentCreatingDTO assignmentCreatingDTO) {
        Assignment newAssignment = Assignment.builder()
                .name(assignmentCreatingDTO.getName())
                .dueTime(assignmentCreatingDTO.getDueTime())
                .points(assignmentCreatingDTO.getPoints())
                .classroom(classroomRepository.findById(assignmentCreatingDTO.getClassroomId()).
                        orElseThrow(CompanyClassroomException::classroomNotFound))
                .instruction(assignmentCreatingDTO.getInstruction())
                .attachment(assignmentCreatingDTO.getAttachment())
        .build();
        return AssignmentMapper.ASSIGNMENT_MAPPER.toDto(assignmentRepository.save(newAssignment));
    }

    @Override
    public AssignmentDTO updateAssignmentById(Long assignmentId, AssignmentCreatingDTO assignmentCreatingDTO) {
        Assignment updatedAssignment = assignmentRepository.findById(assignmentId).orElseThrow(CompanyClassroomException::assignmentNotFound);
        if(assignmentCreatingDTO.getName() != null)
            updatedAssignment.setName(assignmentCreatingDTO.getName());
        if(assignmentCreatingDTO.getPoints() != null)
            updatedAssignment.setPoints(assignmentCreatingDTO.getPoints());
        if(assignmentCreatingDTO.getAttachment() != null)
            updatedAssignment.setAttachment(assignmentCreatingDTO.getAttachment());
        if(assignmentCreatingDTO.getInstruction() != null)
            updatedAssignment.setInstruction(assignmentCreatingDTO.getInstruction());
        if(assignmentCreatingDTO.getDueTime() != null)
            updatedAssignment.setDueTime(assignmentCreatingDTO.getDueTime());
        return AssignmentMapper.ASSIGNMENT_MAPPER.toDto(assignmentRepository.save(updatedAssignment));
    }

    @Override
    public void deleteAssignmentById(Long assignmentId) {
        assignmentRepository.findById(assignmentId);
        assignmentRepository.deleteById(assignmentId);
    }

    @Override
    public List<UserDTO> getStudentHasNoSubmissionByAssignmentId(Long assignmentId) {
            return UserMapper.USER_MAPPER.toDtos(assignmentRepository.getStudentHasNoSubmissionByAssignmentId(assignmentId));
    }

    @Override
    public List<UserDTO> getStudentHasSubmissionByAssignmentId(Long assignmentId) {
            return UserMapper.USER_MAPPER.toDtos(assignmentRepository.getStudentHasSubmissionByAssignmentId(assignmentId));
    }
}
