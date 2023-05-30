package com.nonit.classroom.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
