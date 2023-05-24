package com.personalproject.companyclassroom.service.dto.creatingDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreatingDTO {
    private LocalDate date;
    private String content;
    private String attachment;
    private Long postId;
    private Long userId;
}
