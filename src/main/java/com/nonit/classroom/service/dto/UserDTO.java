package com.nonit.classroom.service.dto;

import com.nonit.classroom.entity.Gender;
import com.nonit.classroom.entity.Role;
import com.nonit.classroom.entity.UserRoleAssignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String username;
    private String password;
    private String avatar;
    private Role role;
}
