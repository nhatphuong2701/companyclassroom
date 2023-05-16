package com.personalproject.axonclassroom.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherCreatingDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String avatar;
}
