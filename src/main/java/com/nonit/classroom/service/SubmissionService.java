package com.nonit.classroom.service;

import com.nonit.classroom.service.dto.SubmissionDTO;

import java.util.List;

public interface SubmissionService {

    List<SubmissionDTO> getAllSubmission();

    SubmissionDTO createSubmission(SubmissionDTO submissionDTO);

    SubmissionDTO updateSubmission(Long submissionId, SubmissionDTO submissionDTO);

    void deleteSubmission(Long submissionId);
}
