package com.personalproject.companyclassroom.security.service.impl;

import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.security.entity.User;
import com.personalproject.companyclassroom.security.entity.UserRoleAssignment;
import com.personalproject.companyclassroom.security.repository.UserRepository;
import com.personalproject.companyclassroom.security.repository.UserRoleAssignmentRepository;
import com.personalproject.companyclassroom.security.service.UserService;
import com.personalproject.companyclassroom.security.service.dto.UserCreatingDTO;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import com.personalproject.companyclassroom.security.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserDTO> getAllUsers() {
        return UserMapper.USER_MAPPER.toDtos(userRepository.findAll());
    }

    @Override
    public UserDTO createUser(UserCreatingDTO userCreatingDTO) {
        if(userCreatingDTO.getFirstName().isBlank() ||
                userCreatingDTO.getLastName().isBlank() ||
                userCreatingDTO.getUsername().isBlank() ){
            throw CompanyClassroomException.badRequest("InvalidInput",
                    "User's first name, last name and username must be filled");
        }

        if (userCreatingDTO.getUsername().length() >= 15) {
            throw CompanyClassroomException.badRequest("InvalidUsername","User name must not be longer than 15 symbols");
        }

        if (!(userCreatingDTO.getPassword().matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=])(?=\\S+$).{8,16}$"))) {
            throw CompanyClassroomException.badRequest("InvalidPassword",
                    "Password must have at least 1 lowercase, 1 uppercase, 1 numeric char, " +
                            "1 special char, 8 chars to 16 chars");
        }
        User user = User.builder()
                .firstName(userCreatingDTO.getFirstName())
                .lastName(userCreatingDTO.getLastName())
                .password(passwordEncoder.encode(userCreatingDTO.getPassword()))
                .username(userCreatingDTO.getUsername())
                .email(userCreatingDTO.getEmail())
                .gender(userCreatingDTO.getGender())
                .dateOfBirth(userCreatingDTO.getDateOfBirth())
                .avatar(userCreatingDTO.getAvatar())
                .build();
        UserRoleAssignment userRoleAssignment = UserRoleAssignment.builder()
                .user(user)
                .role(userCreatingDTO.getRole())
                .build();
        user.setUserRoleAssignment(userRoleAssignment);
        return UserMapper.USER_MAPPER.toDto(userRepository.save(user));
    }

    @Override
    public UserDTO updateUserByIdForAdmin(Long userId, UserCreatingDTO userCreatingDTO) {
        User user = userRepository.findById(userId).orElseThrow(CompanyClassroomException::userNotFound);
        if (userCreatingDTO.getFirstName() != null)
            user.setFirstName(userCreatingDTO.getFirstName());
        if (userCreatingDTO.getLastName() != null)
            user.setLastName(userCreatingDTO.getLastName());
        if (userCreatingDTO.getGender() != null)
            user.setGender(userCreatingDTO.getGender());
        if (userCreatingDTO.getDateOfBirth() != null)
            user.setDateOfBirth(userCreatingDTO.getDateOfBirth());
        if (userCreatingDTO.getEmail() != null)
            user.setEmail(userCreatingDTO.getEmail());
        if (userCreatingDTO.getUsername() != null)
            user.setUsername(userCreatingDTO.getUsername());

        if(user.getUserRoleAssignment().getUser() == user){
            if(userCreatingDTO.getRole() !=  user.getUserRoleAssignment().getRole()) {
                user.getUserRoleAssignment().setRole(userCreatingDTO.getRole());
            }
        }
        return UserMapper.USER_MAPPER.toDto(userRepository.save(user));
    }

    @Override
    public UserDTO updateUserByIdForUser(Long userId, UserCreatingDTO userCreatingDTO) {
        User user = userRepository.findById(userId).orElseThrow(CompanyClassroomException::userNotFound);

        if (userCreatingDTO.getFirstName() != null)
            user.setFirstName(userCreatingDTO.getFirstName());
        if (userCreatingDTO.getLastName() != null)
            user.setLastName(userCreatingDTO.getLastName());
        if (userCreatingDTO.getGender() != null)
            user.setGender(userCreatingDTO.getGender());
        if (userCreatingDTO.getDateOfBirth() != null)
            user.setDateOfBirth(userCreatingDTO.getDateOfBirth());
        return UserMapper.USER_MAPPER.toDto(userRepository.save(user));
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.findById(id).orElseThrow(CompanyClassroomException::userNotFound);
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return UserMapper.USER_MAPPER.toDto(userRepository.findById(id).orElseThrow(CompanyClassroomException::userNotFound));
    }

    @Override
    public UserDTO getUserByUserName(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> CompanyClassroomException.badRequest("user_BAD_REQUEST", "user bad request"));
        if (userName.isBlank()) {
            throw CompanyClassroomException.badRequest("user_BAD_REQUEST", "user bad request");
        }
        return UserMapper.USER_MAPPER.toDto(user);
    }

    @Override
    public List<UserDTO> getStudentsByClassroomId(Role role, Long classroomId) {
        return UserMapper.USER_MAPPER.toDtos(userRepository.getStudentsByClassroomId(role, classroomId));
    }
}
