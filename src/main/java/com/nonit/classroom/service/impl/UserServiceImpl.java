package com.nonit.classroom.service.impl;

import com.nonit.classroom.entity.Gender;
import com.nonit.classroom.entity.Role;
import com.nonit.classroom.entity.User;
import com.nonit.classroom.entity.UserRoleAssignment;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.UserRepository;
import com.nonit.classroom.service.UserService;
import com.nonit.classroom.service.dto.UserDTO;
import com.nonit.classroom.service.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public List<UserDTO> getAllUsers() {
        return UserMapper.INSTANCE.toDtos(userRepository.findAll());
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        checkDTO(userDTO);
        User user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .gender(userDTO.getGender())
                .dateOfBirth(userDTO.getDateOfBirth())
                .avatar(userDTO.getAvatar())
                .build();

        UserRoleAssignment userRoleAssignment = UserRoleAssignment.builder()
                .user(user)
                .role(userDTO.getRole())
                .build();

        user.setUserRoleAssignment(userRoleAssignment);
        logger.info("create user successfully");
        return UserMapper.INSTANCE.toDto(userRepository.save(user));
    }

    @Override
    public UserDTO updateUserForAdmin(Long userId, UserDTO userDTO) {
        User updatedUser = userRepository.findById(userId)
                .orElseThrow(ClassroomException::userNotFound);
        UserMapper.INSTANCE.updateUserForAdminFromDTO(userDTO, updatedUser);
        return UserMapper.INSTANCE.toDto(userRepository.save(updatedUser));
    }

    @Override
    public UserDTO updateUserForUser(Long userId, UserDTO userDTO) {
        User updatedUser = userRepository.findById(userId)
                .orElseThrow(ClassroomException::userNotFound);
        UserMapper.INSTANCE.updateUserForUserFromDTO(userDTO, updatedUser);
        return UserMapper.INSTANCE.toDto(userRepository.save(updatedUser));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        return UserMapper.INSTANCE.toDto(userRepository.findById(userId)
                .orElseThrow(ClassroomException::userNotFound));
    }

    @Override
    public UserDTO getUserByUsername(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> ClassroomException.badRequest("user_BAD_REQUEST", "user bad request"));
        if (userName.isBlank()) {
            throw ClassroomException.badRequest("user_BAD_REQUEST", "user bad request");
        }
        return UserMapper.INSTANCE.toDto(user);
    }

    @Override
    public List<UserDTO> getStudentsByClassroomId(Long classId) {
        return UserMapper.INSTANCE.toDtos(userRepository.getStudentsByClassroomId(classId));
    }

    @Override
    public List<UserDTO> importStudentsFromFile(MultipartFile file) throws IOException {
        List<User> students = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);
        logger.info("row number" + worksheet.getPhysicalNumberOfRows());
        for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
            XSSFRow row = worksheet.getRow(i);

            if (row.getCell(0) == null) {
                break;
            }

                User student = new User();
                UserRoleAssignment userRoleAssignment = new UserRoleAssignment();

                student.setFirstName(row.getCell(0).getStringCellValue());
                student.setLastName(row.getCell(1).getStringCellValue());
                student.setEmail(row.getCell(2).getStringCellValue());
                student.setGender(Gender.valueOf(row.getCell(3).getStringCellValue()));
                student.setDateOfBirth(LocalDate.parse(row.getCell(4).getStringCellValue()));
                student.setAvatar(row.getCell(5).getStringCellValue());
                student.setUsername(row.getCell(6).getStringCellValue());
                student.setPassword(passwordEncoder.encode(row.getCell(7).getStringCellValue()));
                userRoleAssignment.setRole(Role.valueOf(row.getCell(8).getStringCellValue()));
                userRoleAssignment.setUser(student);
                student.setUserRoleAssignment(userRoleAssignment);

                students.add(student);
            }

        return UserMapper.INSTANCE.toDtos(userRepository.saveAll(students));
    }

    private static void checkDTO(UserDTO userDTO) {
        if (userDTO.getFirstName().isBlank() ||
                userDTO.getLastName().isBlank() ||
                userDTO.getUsername().isBlank()) {
            throw ClassroomException.badRequest("InvalidInput",
                    "User's first name, last name and username must be filled");
        }

        if (userDTO.getUsername().length() >= 15) {
            throw ClassroomException.badRequest("InvalidUsername",
                    "User name must not be longer than 15 symbols");
        }

        if (userDTO.getPassword().length() > 24 || userDTO.getPassword().length() < 5) {
            throw ClassroomException.badRequest("InvalidPassword",
                    "Password must contain 8 chars to 24 chars");
        }
    }
}
