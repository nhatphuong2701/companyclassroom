package com.nonit.classroom.rest.api;

import com.nonit.classroom.service.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static com.nonit.classroom.constant.AuthorityConstants.*;

@RequestMapping("/api/users")

public interface UserAPI {

    @PreAuthorize(HAS_ROLE_ADMIN)
    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers();

    @PreAuthorize(HAS_ROLE_ADMIN)
    @PostMapping
    ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @PutMapping("/admin_updating/{userId}")
    ResponseEntity<UserDTO> updateUserForAdmin(@PathVariable Long teacherId, @RequestBody UserDTO userDTO);

    @PreAuthorize(HAS_ROLE_TEACHER_STUDENT)
    @PutMapping("/user_updating/{userId}")
    ResponseEntity<UserDTO> updateUserForUser(@PathVariable Long teacherId, @RequestBody UserDTO userDTO);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @DeleteMapping("/{userId}")
    ResponseEntity<Void> deleteUser(@PathVariable Long userId);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @GetMapping("/{userId}")
    ResponseEntity<UserDTO> getUserById(@PathVariable Long userId);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @GetMapping("/username")
    ResponseEntity<UserDTO> getUserByUsername(@RequestParam String username);

    @PreAuthorize(HAS_ROLE_TEACHER_ADMIN)
    @GetMapping("/student-from-classroom")
    ResponseEntity<List<UserDTO>> getStudentsByClassroomId(@RequestParam Long classId);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @PostMapping("/import-students-from-file")
    ResponseEntity<List<UserDTO>> importStudentsFromFile(@RequestBody MultipartFile file) throws IOException;
}
