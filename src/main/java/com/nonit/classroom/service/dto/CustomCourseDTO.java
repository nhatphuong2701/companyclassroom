package com.nonit.classroom.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomCourseDTO {
    private String name;
    private Long numberOfClasses;
    private Long numberOfStudents;
}
