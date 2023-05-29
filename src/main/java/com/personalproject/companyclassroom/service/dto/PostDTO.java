package com.personalproject.companyclassroom.service.dto;

import com.personalproject.companyclassroom.entity.Classroom;
import com.personalproject.companyclassroom.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private LocalDate postDate;
    private String content;
    private String attachment;
    private String title;
    private Long classroomId;
    private Long userId;
}
