package com.personalproject.companyclassroom.security.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatingDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private String avatar;
}
