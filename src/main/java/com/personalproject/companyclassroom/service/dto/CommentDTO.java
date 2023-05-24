package com.personalproject.companyclassroom.service.dto;

import com.personalproject.companyclassroom.entity.Post;
import com.personalproject.companyclassroom.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long id;
    private LocalDate date;
    private String content;
    private String attachment;
    private Post post;
    private User user;
}
