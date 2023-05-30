package com.nonit.classroom.rest.api;

import com.nonit.classroom.service.dto.SubmissionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nonit.classroom.constant.AuthorityConstants.*;

@RequestMapping("/api/submissions")
public interface SubmissionAPI {

    @PreAuthorize(HAS_ROLE_TEACHER_ADMIN)
    @GetMapping
    ResponseEntity<List<SubmissionDTO>> getAllSubmissions();

    @PreAuthorize(HAS_ROLE_TEACHER_ADMIN)
    @PostMapping
    ResponseEntity<SubmissionDTO> createSubmission(@RequestBody SubmissionDTO submissionDTO);

    @PreAuthorize(HAS_ROLE_TEACHER)
    @PutMapping("/{submissionId}")
    ResponseEntity<SubmissionDTO> updateSubmissionPointById(@PathVariable Long submissionId,
                                                            @RequestBody SubmissionDTO submissionDTO);

    @PreAuthorize(HAS_ROLE_STUDENT)
    @DeleteMapping("/{submissionId}")
    ResponseEntity<Void> deleteSubmissionById(@PathVariable("submissionId") Long submissionId);
}
