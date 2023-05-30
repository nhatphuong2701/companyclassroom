package com.nonit.classroom.service.impl;

import com.nonit.classroom.repository.UserRepository;
import com.nonit.classroom.service.dto.creatingDTO.SubmissionCreatingDTO;
import com.nonit.classroom.service.mapper.SubmissionMapper;
import com.nonit.classroom.entity.Submission;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.AssignmentRepository;
import com.nonit.classroom.repository.SubmissionRepository;
import com.nonit.classroom.service.SubmissionService;
import com.nonit.classroom.service.dto.SubmissionDTO;
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
        return SubmissionMapper.SUBMISSION_MAPPER.toDtos(submissionRepository.findAll());
    }

    @Override
    public SubmissionDTO createSubmission(SubmissionCreatingDTO submissionCreatingDTO) {
        Submission newSubmission = Submission.builder()
                .user(userRepository.findById(submissionCreatingDTO.getUserId()).orElseThrow(ClassroomException::userNotFound))
                .assignment(assignmentRepository.findById(submissionCreatingDTO.getAssignmentId()).orElseThrow(ClassroomException::assignmentNotFound))
                .note(submissionCreatingDTO.getNote())
                .attachment(submissionCreatingDTO.getAttachment())
                .build();
        return SubmissionMapper.SUBMISSION_MAPPER.toDto(submissionRepository.save(newSubmission));
    }

    @Override
    public SubmissionDTO updateSubmissionPointById(Long submissionId, SubmissionCreatingDTO submissionCreatingDTO) {
        Submission updatedSubmission = submissionRepository.findById(submissionId).
                orElseThrow(ClassroomException::submissionNotFound);
        if(submissionCreatingDTO.getPoints()!=null)
            updatedSubmission.setPoints(submissionCreatingDTO.getPoints());
        return SubmissionMapper.SUBMISSION_MAPPER.toDto(submissionRepository.save(updatedSubmission));
    }

    @Override
    public void deleteSubmissionById(Long submissionId) {
        submissionRepository.findById(submissionId);
        submissionRepository.deleteById(submissionId);
    }
}
