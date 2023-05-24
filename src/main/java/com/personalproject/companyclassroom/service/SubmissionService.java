package com.personalproject.companyclassroom.service;

import com.personalproject.companyclassroom.service.dto.creatingDTO.SubmissionCreatingDTO;
import com.personalproject.companyclassroom.service.dto.SubmissionDTO;

import java.util.List;

public interface SubmissionService {

    List<SubmissionDTO> getAllSubmission();

    SubmissionDTO createSubmission(SubmissionCreatingDTO submissionCreatingDTO);

    SubmissionDTO updateSubmissionById(Long submissionId, SubmissionCreatingDTO submissionCreatingDTO);

    void deleteSubmissionById(Long submissionId);
}
