package com.nonit.classroom.service.dto;

import com.nonit.classroom.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private Long id;
    private LocalDate postDate;

    @NotNull
    private String content;

    private String attachment;
    private String title;
    private Long classId;
    private Long userId;
    private List<Long> commentIds;
}
