package com.personalproject.companyclassroom.service.dto;

import com.personalproject.companyclassroom.entity.Post;
import com.personalproject.companyclassroom.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {
    private Long id;
    private LocalDateTime time;
    private String content;
    private List<String> attachments;
    private Post post;
    private User user;
}
