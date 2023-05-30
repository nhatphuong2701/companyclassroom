package com.nonit.classroom.rest.resource;

import com.nonit.classroom.rest.api.SubmissionAPI;
import com.nonit.classroom.service.SubmissionService;
import com.nonit.classroom.service.dto.SubmissionDTO;
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
    public ResponseEntity<SubmissionDTO> createSubmission(SubmissionDTO submissionDTO) {
        SubmissionDTO newSubmission = submissionService.createSubmission(submissionDTO);
        return ResponseEntity.created(URI.create("/api/submissions/" + newSubmission.getId())).body(newSubmission);
    }

    @Override
    public ResponseEntity<SubmissionDTO> updateSubmissionPointById(Long submissionId, SubmissionDTO submissionDTO) {
        return ResponseEntity.ok().body(submissionService.updateSubmission(submissionId, submissionDTO));
    }

    @Override
    public ResponseEntity<Void> deleteSubmissionById(Long submissionId) {
        submissionService.deleteSubmission(submissionId);
        return ResponseEntity.noContent().build();
    }
}
