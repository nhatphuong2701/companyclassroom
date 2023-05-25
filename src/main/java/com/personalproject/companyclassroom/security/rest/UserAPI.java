package com.personalproject.companyclassroom.security.rest;

import com.personalproject.companyclassroom.security.service.dto.UserCreatingDTO;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")

public interface UserAPI {
    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers();

    @PostMapping
    ResponseEntity<UserDTO> createUser(@RequestBody UserCreatingDTO userCreatingDTO);

    @PutMapping("/admin_updating/{userId}")
    ResponseEntity<UserDTO> updateUserByIdForAdmin(@PathVariable("userId") Long teacherId, @RequestBody UserCreatingDTO userCreatingDTO);

    @PutMapping("/user_updating/{userId}")
    ResponseEntity<UserDTO> updateUserByIdForUser(@PathVariable("userId") Long teacherId, @RequestBody UserCreatingDTO userCreatingDTO);

    @DeleteMapping("/{userId}")
    void deleteUserById(@PathVariable("userId") Long id);

    @GetMapping("/{userId}")
    ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Long userId);

    @GetMapping("/username")
    ResponseEntity<UserDTO> getUserByUsername(@RequestParam("username") String username);
}
