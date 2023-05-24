package com.personalproject.companyclassroom.rest.api;

import com.personalproject.companyclassroom.service.dto.creatingDTO.SubmissionCreatingDTO;
import com.personalproject.companyclassroom.service.dto.SubmissionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/submissions")
public interface SubmissionAPI {

    @GetMapping
    ResponseEntity<List<SubmissionDTO>> getAllSubmissions();

    @PostMapping
    ResponseEntity<SubmissionDTO> createSubmission(@RequestBody SubmissionCreatingDTO submissionCreatingDTO);

    @PutMapping("/{submissionId}")
    ResponseEntity<SubmissionDTO> updateSubmissionById(@PathVariable("submissionId") Long submissionId, @RequestBody SubmissionCreatingDTO submissionCreatingDTO);

    @DeleteMapping("/{submissionId}")
    void deleteSubmissionById(@PathVariable("submissionId") Long submissionId);
}
