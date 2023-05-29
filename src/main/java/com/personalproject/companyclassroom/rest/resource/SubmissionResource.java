package com.personalproject.companyclassroom.rest.resource;

import com.personalproject.companyclassroom.rest.api.SubmissionAPI;
import com.personalproject.companyclassroom.service.SubmissionService;
import com.personalproject.companyclassroom.service.dto.creatingDTO.SubmissionCreatingDTO;
import com.personalproject.companyclassroom.service.dto.SubmissionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class SubmissionResource implements SubmissionAPI {
    @Autowired
    private SubmissionService submissionService;

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
    public ResponseEntity<SubmissionDTO> updateSubmissionPointById(Long submissionId, SubmissionCreatingDTO submissionCreatingDTO) {
        return ResponseEntity.ok().body(submissionService.updateSubmissionPointById(submissionId,submissionCreatingDTO));
    }

    @Override
    public void deleteSubmissionById(Long submissionId) {
        submissionService.deleteSubmissionById(submissionId);
        ResponseEntity.noContent().build();
    }
}
