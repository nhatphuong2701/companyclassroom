package com.personalproject.axonclassroom.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherUpdatingDTO {
    private String firstName;
    private String lastName;
    private String email;
}
