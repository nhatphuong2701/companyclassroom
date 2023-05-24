package com.personalproject.companyclassroom.security.service.impl;

import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.security.entity.User;
import com.personalproject.companyclassroom.security.entity.UserRoleAssignment;
import com.personalproject.companyclassroom.security.repository.UserRepository;
import com.personalproject.companyclassroom.security.service.UserService;
import com.personalproject.companyclassroom.security.service.dto.UserCreatingDTO;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import com.personalproject.companyclassroom.security.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUsers() {
        return UserMapper.USER_MAPPER.toDtos(userRepository.findAll());
    }

    @Override
    public UserDTO createUser(UserCreatingDTO userCreatingDTO) {
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
        List<UserRoleAssignment> userRoleAssignments = new ArrayList<>();
        List<Role> assignedRoles = userCreatingDTO.getRoles();
        assignedRoles.forEach(assignedRole -> {
            UserRoleAssignment userRoleAssignment = UserRoleAssignment.builder()
                    .role(assignedRole)
                    .users(user)
                    .build();
            userRoleAssignments.add(userRoleAssignment);
        });

        user.setRoles(userRoleAssignments);
        return UserMapper.USER_MAPPER.toDto(userRepository.save(user));
    }

    @Override
    public UserDTO updateUserById(Long id, UserCreatingDTO userCreatingDTO) {
        User user = userRepository.findById(id).orElseThrow(CompanyClassroomException::userNotFound);
        user.setFirstName(userCreatingDTO.getFirstName());
        user.setLastName(userCreatingDTO.getLastName());
        user.setEmail(userCreatingDTO.getEmail());
        user.setGender(userCreatingDTO.getGender());
        user.setDateOfBirth(userCreatingDTO.getDateOfBirth());
        user.setUsername(userCreatingDTO.getUsername());
        user.setPassword(userCreatingDTO.getPassword());
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
}
