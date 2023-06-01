package com.nonit.classroom.service.impl;

import com.nonit.classroom.entity.Submission;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.AssignmentRepository;
import com.nonit.classroom.repository.SubmissionRepository;
import com.nonit.classroom.repository.UserRepository;
import com.nonit.classroom.service.SubmissionService;
import com.nonit.classroom.service.dto.SubmissionDTO;
import com.nonit.classroom.service.mapper.SubmissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    @Override
    public List<SubmissionDTO> getAllSubmission() {
        return SubmissionMapper.INSTANCE.toDtos(submissionRepository.findAll());
    }

    @Override
    public SubmissionDTO createSubmission(SubmissionDTO submissionDTO) {
        Submission newSubmission = Submission.builder()
                .user(userRepository.findById(submissionDTO.getUserId())
                        .orElseThrow(ClassroomException::userNotFound))
                .assignment(assignmentRepository.findById(submissionDTO.getAssignmentId())
                        .orElseThrow(ClassroomException::assignmentNotFound))
                .note(submissionDTO.getNote())
                .attachment(submissionDTO.getAttachment())
                .build();
        return SubmissionMapper.INSTANCE.toDto(submissionRepository.save(newSubmission));
    }

    @Override
    public SubmissionDTO updateSubmission(Long submissionId, SubmissionDTO submissionDTO) {
        Submission updatedSubmission = submissionRepository.findById(submissionId).
                orElseThrow(ClassroomException::submissionNotFound);
        SubmissionMapper.INSTANCE.updateSubmissionFromDTO(submissionDTO, updatedSubmission);
        return SubmissionMapper.INSTANCE.toDto(submissionRepository.save(updatedSubmission));
    }

    @Override
    public void deleteSubmission(Long submissionId) {
        submissionRepository.deleteById(submissionId);
    }
}
