package com.nonit.classroom.service;

import com.nonit.classroom.service.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUserForAdmin(Long userId, UserDTO userDTO);

    UserDTO updateUserForUser(Long userId, UserDTO userDTO);

    void deleteUser(Long userId);

    UserDTO getUserById(Long userId);

    UserDTO getUserByUsername(String username);

    List<UserDTO> getStudentsByClassroomId(Long classId);

    List<UserDTO> importStudentsFromFile(MultipartFile file) throws IOException;
}
