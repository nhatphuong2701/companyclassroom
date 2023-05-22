package com.personalproject.companyclassroom.security.service;

import com.personalproject.companyclassroom.security.service.dto.UserCreatingDTO;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO createUser(UserCreatingDTO userCreatingDTO);

    UserDTO updateUserById(Long userId, UserCreatingDTO userCreatingDTO);

    void deleteUserById(Long id);

    UserDTO getUserById(Long id);

    UserDTO getUserByUserName(String userName);
}