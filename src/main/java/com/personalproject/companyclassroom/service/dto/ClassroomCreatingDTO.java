package com.personalproject.companyclassroom.service.dto;

import com.personalproject.companyclassroom.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassroomCreatingDTO {
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long academicYear;
    private String code;
    private Long courseId;
}
