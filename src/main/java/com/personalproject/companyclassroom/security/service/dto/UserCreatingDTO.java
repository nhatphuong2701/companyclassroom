package com.personalproject.companyclassroom.security.service.dto;

import com.personalproject.companyclassroom.security.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatingDTO {
    private String firstName;
    private String lastName;
    private String email;
    private List<Role> roles;
    private String username;
    private String password;
    private String avatar;
    private Boolean active;
}
