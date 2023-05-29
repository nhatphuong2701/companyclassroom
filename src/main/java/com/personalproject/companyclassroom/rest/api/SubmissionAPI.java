package com.personalproject.companyclassroom.rest.api;

import com.personalproject.companyclassroom.service.dto.creatingDTO.SubmissionCreatingDTO;
import com.personalproject.companyclassroom.service.dto.SubmissionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/submissions")
public interface SubmissionAPI {
    @PreAuthorize(value = "hasAnyRole('TEACHER','ADMIN')")
    @GetMapping
    ResponseEntity<List<SubmissionDTO>> getAllSubmissions();

    @PreAuthorize(value = "hasAnyRole('STUDENT','ADMIN')")
    @PostMapping
    ResponseEntity<SubmissionDTO> createSubmission(@RequestBody SubmissionCreatingDTO submissionCreatingDTO);

    @PreAuthorize(value = "hasAnyRole('TEACHER')")
    @PutMapping("/{submissionId}")
    ResponseEntity<SubmissionDTO> updateSubmissionPointById(@PathVariable("submissionId") Long submissionId, @RequestBody SubmissionCreatingDTO submissionCreatingDTO);

    @PreAuthorize(value = "hasAnyRole('STUDENT')")
    @DeleteMapping("/{submissionId}")
    void deleteSubmissionById(@PathVariable("submissionId") Long submissionId);
}
