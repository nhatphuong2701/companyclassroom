package com.nonit.classroom.service.impl;

import com.nonit.classroom.entity.Assignment;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.AssignmentRepository;
import com.nonit.classroom.repository.ClassRepository;
import com.nonit.classroom.repository.UserRepository;
import com.nonit.classroom.service.AssignmentService;
import com.nonit.classroom.service.dto.AssignmentDTO;
import com.nonit.classroom.service.dto.UserDTO;
import com.nonit.classroom.service.mapper.AssignmentMapper;
import com.nonit.classroom.service.mapper.UserMapper;
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
    private ClassRepository classRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AssignmentDTO> getAllAssignments() {
        return AssignmentMapper.INSTANCE.toDtos(assignmentRepository.findAll());
    }

    @Override
    public AssignmentDTO createAssignment(AssignmentDTO assignmentDTO) {
        Assignment newAssignment = Assignment.builder()
                .name(assignmentDTO.getName())
                .dueTime(assignmentDTO.getDueTime())
                .points(assignmentDTO.getPoints())
                .clazz(classRepository.findById(assignmentDTO.getClassId()).
                        orElseThrow(ClassroomException::classroomNotFound))
                .instruction(assignmentDTO.getInstruction())
                .attachment(assignmentDTO.getAttachment())
                .build();
        return AssignmentMapper.INSTANCE.toDto(assignmentRepository.save(newAssignment));
    }

    @Override
    public AssignmentDTO updateAssignment(Long assignmentId, AssignmentDTO assignmentDTO) {
        Assignment updatedAssignment = assignmentRepository.findById(assignmentId)
                .orElseThrow(ClassroomException::assignmentNotFound);
        AssignmentMapper.INSTANCE.updateAssignmentFromDTO(assignmentDTO, updatedAssignment);
        return AssignmentMapper.INSTANCE.toDto(assignmentRepository.save(updatedAssignment));
    }

    @Override
    public void deleteAssignment(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }

    @Override
    public List<UserDTO> getStudentHasNoSubmissionByAssignmentId(Long assignmentId) {
        return UserMapper.INSTANCE.toDtos(assignmentRepository.getStudentHasNoSubmissionByAssignmentId(assignmentId));
    }

    @Override
    public List<UserDTO> getStudentHasSubmissionByAssignmentId(Long assignmentId) {
        return UserMapper.INSTANCE.toDtos(assignmentRepository.getStudentHasSubmissionByAssignmentId(assignmentId));
    }
}
