package com.personalproject.companyclassroom.service.dto.creatingDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreatingDTO {
    private LocalDateTime time;
    private String content;
    private String attachment;
    private Long postId;
    private Long userId;
}
