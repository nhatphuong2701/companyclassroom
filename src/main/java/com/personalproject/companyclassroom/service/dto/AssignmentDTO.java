package com.personalproject.companyclassroom.service.dto;

import com.personalproject.companyclassroom.entity.Classroom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentDTO {
    private Long id;
    private String name;
    private LocalDate dueDate;
    private String attachment;
    private String instruction;
    private Long points;
    private Classroom classroom;
}
