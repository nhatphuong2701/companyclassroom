package com.personalproject.companyclassroom.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentCreatingDTO {
    private String name;
    private LocalDate dueDate;
    private String attachment;
    private String instruction;
    private Long points;
    private Long classroomId;
}
