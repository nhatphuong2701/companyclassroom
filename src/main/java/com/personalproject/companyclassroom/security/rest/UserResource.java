package com.personalproject.companyclassroom.security.rest;


import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.exception.ResponseException;
import com.personalproject.companyclassroom.security.service.UserService;
import com.personalproject.companyclassroom.security.service.dto.UserCreatingDTO;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class UserResource implements UserAPI {
    private final UserService userService;
    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserDTO> updateUserById(Long userId, UserCreatingDTO userCreatingDTO) {
        return ResponseEntity.ok().body(userService.updateUserById(userId, userCreatingDTO));
    }

    @Override
    public void deleteUserById(Long userId) {
        userService.deleteUserById(userId);
        ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @Override
    public ResponseEntity<UserDTO> getUserByUsername(String username){
        try{
            return ResponseEntity.ok(userService.getUserByUserName(username));
        } catch (ResponseException ex) {
            throw CompanyClassroomException.badRequest("USERNAME_DOES_NOT_EXIST", "Username does not exist");
        }
    }
}
