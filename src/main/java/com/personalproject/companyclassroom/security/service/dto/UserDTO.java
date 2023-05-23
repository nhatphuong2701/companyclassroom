package com.personalproject.companyclassroom.security.service.dto;

import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.security.entity.UserRoleAssignment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String avatar;
    private List<UserRoleAssignment> roles;
}
