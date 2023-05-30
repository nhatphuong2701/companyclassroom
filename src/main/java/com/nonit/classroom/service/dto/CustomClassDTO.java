package com.nonit.classroom.service.dto;

import com.nonit.classroom.entity.Clazz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomClassDTO {
    private Clazz clazz;
    private Long numberOfStudents;
}
