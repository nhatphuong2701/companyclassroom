package com.nonit.classroom.rest.resource;

import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.exception.ResponseException;
import com.nonit.classroom.rest.api.UserAPI;
import com.nonit.classroom.service.UserService;
import com.nonit.classroom.service.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.List;

@RestController
public class UserResource implements UserAPI {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        UserDTO newUser = userService.createUser(userDTO);
        return ResponseEntity.created(URI.create("/api/users/" + newUser.getId())).body(newUser);
    }

    @Override
    public ResponseEntity<UserDTO> updateUserForAdmin(Long userId, UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.updateUserForAdmin(userId, userDTO));
    }

    @Override
    public ResponseEntity<UserDTO> updateUserForUser(Long userId, UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.updateUserForUser(userId, userDTO));
    }

    @Override
    public ResponseEntity<Void> deleteUser(Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @Override
    public ResponseEntity<UserDTO> getUserByUsername(String username) {
        try {
            return ResponseEntity.ok(userService.getUserByUsername(username));
        } catch (ResponseException ex) {
            throw ClassroomException.badRequest("USERNAME_DOES_NOT_EXIST", "Username does not exist");
        }
    }

    @Override
    public ResponseEntity<List<UserDTO>> getStudentsByClassroomId(Long classId) {
        return ResponseEntity.ok(userService.getStudentsByClassroomId(classId));
    }

    @Override
    public ResponseEntity<List<UserDTO>> importStudentsFromFile(MultipartFile file) throws IOException {
        return ResponseEntity.ok(userService.importStudentsFromFile(file));
    }
}
