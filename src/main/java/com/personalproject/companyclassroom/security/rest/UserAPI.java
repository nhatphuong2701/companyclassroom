package com.personalproject.companyclassroom.security.rest;

import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.security.service.dto.UserCreatingDTO;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/api/users")

public interface UserAPI {
    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers();

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping
    ResponseEntity<UserDTO> createUser(@RequestBody UserCreatingDTO userCreatingDTO);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping("/admin_updating/{userId}")
    ResponseEntity<UserDTO> updateUserByIdForAdmin(@PathVariable("userId") Long teacherId, @RequestBody UserCreatingDTO userCreatingDTO);

    @PreAuthorize(value = "hasAnyRole('TEACHER','STUDENT')")
    @PutMapping("/user_updating/{userId}")
    ResponseEntity<UserDTO> updateUserByIdForUser(@PathVariable("userId") Long teacherId, @RequestBody UserCreatingDTO userCreatingDTO);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @DeleteMapping("/{userId}")
    void deleteUserById(@PathVariable("userId") Long id);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/{userId}")
    ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Long userId);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping("/username")
    ResponseEntity<UserDTO> getUserByUsername(@RequestParam("username") String username);

    @PreAuthorize(value = "hasAnyRole('ADMIN','TEACHER')")
    @GetMapping("/student-from-classroom")
    ResponseEntity<List<UserDTO>> getStudentsByClassroomId(@Param("role") Role role, @Param("classroomId") Long classroomId);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping("/import-students-from-file")
    ResponseEntity<List<UserDTO>> importStudentsFromFile(@RequestBody MultipartFile file) throws IOException;
}
