package com.personalproject.companyclassroom.rest;

import com.personalproject.companyclassroom.service.SubmissionService;
import com.personalproject.companyclassroom.service.dto.SubmissionCreatingDTO;
import com.personalproject.companyclassroom.service.dto.SubmissionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class SubmissionResource implements SubmissionAPI{

    private final SubmissionService submissionService;
    @Override
    public ResponseEntity<List<SubmissionDTO>> getAllSubmissions() {
        return ResponseEntity.ok(submissionService.getAllSubmission());
    }

    @Override
    public ResponseEntity<SubmissionDTO> createSubmission(SubmissionCreatingDTO submissionCreatingDTO) {
        SubmissionDTO newSubmission = submissionService.createSubmission(submissionCreatingDTO);
        return ResponseEntity.created(URI.create("/api/submissions/" + newSubmission.getId())).body(newSubmission);
    }

    @Override
    public ResponseEntity<SubmissionDTO> updateSubmissionById(Long submissionId, SubmissionCreatingDTO submissionCreatingDTO) {
        return ResponseEntity.ok().body(submissionService.updateSubmissionById(submissionId,submissionCreatingDTO));
    }

    @Override
    public void deleteSubmissionById(Long submissionId) {
        submissionService.deleteSubmissionById(submissionId);
        ResponseEntity.noContent().build();
    }
}
