package com.personalproject.companyclassroom.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreatingDTO {
    private String content;
    private String attachment;
    private String title;
    private Long userId;
    private Long classroomId;
}
