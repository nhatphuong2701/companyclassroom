package com.personalproject.companyclassroom.service.impl;

import com.personalproject.companyclassroom.entity.Assignment;
import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.repository.AssignmentRepository;
import com.personalproject.companyclassroom.repository.ClassroomRepository;
import com.personalproject.companyclassroom.service.AssignmentService;
import com.personalproject.companyclassroom.service.dto.creatingDTO.AssignmentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.AssignmentDTO;
import com.personalproject.companyclassroom.service.mapper.AssignmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;
    @Autowired
    private ClassroomRepository classroomRepository;
    @Override
    public List<AssignmentDTO> getAllAssignments() {
        return AssignmentMapper.ASSIGNMENT_MAPPER.toDtos(assignmentRepository.findAll());
    }

    @Override
    public AssignmentDTO createAssignment(AssignmentCreatingDTO assignmentCreatingDTO) {
        Assignment newAssignment = Assignment.builder()
                .name(assignmentCreatingDTO.getName())
                .dueDate(assignmentCreatingDTO.getDueDate())
                .points(assignmentCreatingDTO.getPoints())
                .classroom(classroomRepository.findById(assignmentCreatingDTO.getClassroomId()).orElseThrow(CompanyClassroomException::classroomNotFound))
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
        if(assignmentCreatingDTO.getDueDate() != null)
            updatedAssignment.setDueDate(assignmentCreatingDTO.getDueDate());
        return AssignmentMapper.ASSIGNMENT_MAPPER.toDto(assignmentRepository.save(updatedAssignment));
    }

    @Override
    public void deleteAssignmentById(Long assignmentId) {
        assignmentRepository.findById(assignmentId);
        assignmentRepository.deleteById(assignmentId);
    }
}
