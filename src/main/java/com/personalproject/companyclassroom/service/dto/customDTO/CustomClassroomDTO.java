package com.personalproject.companyclassroom.service.dto.customDTO;

import com.personalproject.companyclassroom.entity.Classroom;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomClassroomDTO {
    private Classroom classroom;
    private Long numberOfStudents;
}
