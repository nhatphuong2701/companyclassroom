package com.nonit.classroom.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassDTO {
    private Long id;

    @NotNull
    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    @NotNull
    private Long academicYear;

    private Long courseId;
}
