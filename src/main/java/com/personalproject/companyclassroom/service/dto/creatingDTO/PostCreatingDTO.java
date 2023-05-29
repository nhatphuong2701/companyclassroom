package com.personalproject.companyclassroom.service.dto.creatingDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
