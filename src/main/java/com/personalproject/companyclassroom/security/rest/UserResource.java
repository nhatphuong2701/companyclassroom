package com.personalproject.companyclassroom.security.rest;

import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.exception.ResponseException;
import com.personalproject.companyclassroom.security.service.UserService;
import com.personalproject.companyclassroom.security.service.dto.UserCreatingDTO;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class UserResource implements UserAPI {
    @Autowired
    private UserService userService;
    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserCreatingDTO userCreatingDTO) {
        UserDTO newUser = userService.createUser(userCreatingDTO);
        return ResponseEntity.created(URI.create("/api/users/" + newUser.getId())).body(newUser);
    }

    @Override
    public ResponseEntity<UserDTO> updateUserByIdForAdmin(Long userId, UserCreatingDTO userCreatingDTO) {
        return ResponseEntity.ok().body(userService.updateUserByIdForAdmin(userId, userCreatingDTO));
    }

    @Override
    public ResponseEntity<UserDTO> updateUserByIdForUser(Long userId, UserCreatingDTO userCreatingDTO) {
        return ResponseEntity.ok().body(userService.updateUserByIdForUser(userId, userCreatingDTO));
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

    @Override
    public ResponseEntity<List<UserDTO>> getStudentsByClassroomId(Long classroomId) {
        return ResponseEntity.ok(userService.getStudentsByClassroomId(classroomId));
    }
}
