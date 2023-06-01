package com.nonit.classroom.service.dto;

import com.nonit.classroom.entity.Gender;
import com.nonit.classroom.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    private Gender gender;
    private LocalDate dateOfBirth;

    @NotNull
    private String username;

    @NotNull
    private String password;

    private String avatar;
    private Role role;
}
