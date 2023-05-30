package com.nonit.classroom.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentDTO {
    private Long id;

    @NotNull
    private String name;

    private LocalDateTime dueTime;
    private String attachment;
    private String instruction;
    private Long points;

    @NotNull
    private Long classId;
}
