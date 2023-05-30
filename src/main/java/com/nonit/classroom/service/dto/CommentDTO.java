package com.nonit.classroom.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long id;
    private LocalDateTime time;
    private String content;
    private String attachment;
    private Long postId;
    private Long userId;
}
