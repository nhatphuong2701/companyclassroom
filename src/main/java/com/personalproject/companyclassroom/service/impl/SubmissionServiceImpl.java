package com.personalproject.companyclassroom.service.impl;

import com.personalproject.companyclassroom.entity.Submission;
import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.repository.AssignmentRepository;
import com.personalproject.companyclassroom.repository.SubmissionRepository;
import com.personalproject.companyclassroom.security.repository.UserRepository;
import com.personalproject.companyclassroom.service.SubmissionService;
import com.personalproject.companyclassroom.service.dto.creatingDTO.SubmissionCreatingDTO;
import com.personalproject.companyclassroom.service.dto.SubmissionDTO;
import com.personalproject.companyclassroom.service.mapper.SubmissionMapper;
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
                .user(userRepository.findById(submissionCreatingDTO.getUserId()).orElseThrow(CompanyClassroomException::userNotFound))
                .assignment(assignmentRepository.findById(submissionCreatingDTO.getAssignmentId()).orElseThrow(CompanyClassroomException::assignmentNotFound))
                .note(submissionCreatingDTO.getNote())
                .attachment(submissionCreatingDTO.getAttachment())
                .build();
        return SubmissionMapper.SUBMISSION_MAPPER.toDto(submissionRepository.save(newSubmission));
    }

    @Override
    public SubmissionDTO updateSubmissionPointById(Long submissionId, SubmissionCreatingDTO submissionCreatingDTO) {
        Submission updatedSubmission = submissionRepository.findById(submissionId).
                orElseThrow(CompanyClassroomException::submissionNotFound);
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
