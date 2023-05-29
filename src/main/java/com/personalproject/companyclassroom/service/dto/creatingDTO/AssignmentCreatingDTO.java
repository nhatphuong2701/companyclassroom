package com.personalproject.companyclassroom.service.dto.creatingDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignmentCreatingDTO {
    private String name;
    private LocalDateTime dueTime;
    private String attachment;
    private String instruction;
    private Long points;
    private Long classroomId;
}
