package com.personalproject.companyclassroom.service.dto.creatingDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionCreatingDTO {
    private String note;
    private String attachment;
    private Long points;
    private Long userId;
    private Long assignmentId;
}
