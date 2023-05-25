package com.personalproject.companyclassroom.security.service.impl;

import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.security.service.UserService;
import com.personalproject.companyclassroom.security.service.dto.UserCreatingDTO;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    void updateUserById() {
        List<Role> roles = new ArrayList<>();
        roles.add(Role.ROLE_TEACHER);
        roles.add(Role.ROLE_STUDENT);
        UserCreatingDTO userDTO = new UserCreatingDTO();
        userDTO.setFirstName("A");
        userDTO.setLastName("X");
        userDTO.setEmail("n@m");
        userDTO.setPassword("ZZ");
        userDTO.setUsername("A");
        userDTO.setRoles(roles);
        UserDTO newUser = userService.updateUserById(20L, userDTO);
        System.out.println(newUser);
    }
}