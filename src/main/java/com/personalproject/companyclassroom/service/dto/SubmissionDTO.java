package com.personalproject.companyclassroom.service.dto;

import com.personalproject.companyclassroom.entity.Assignment;
import com.personalproject.companyclassroom.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubmissionDTO {
    private Long id;
    private String note;
    private String attachment;
    private Long points;
    private User user;
    private Assignment assignment;
}
