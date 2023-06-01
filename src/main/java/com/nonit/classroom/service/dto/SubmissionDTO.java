package com.nonit.classroom.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionDTO {
    private Long id;
    private String note;
    private String attachment;
    private Long points;
    private Long userId;
    private Long assignmentId;

    @NotNull
    private LocalDateTime submitTime;
}
