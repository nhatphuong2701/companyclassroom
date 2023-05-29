package com.personalproject.companyclassroom.service.dto.customDTO;

import com.personalproject.companyclassroom.entity.Course;
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
