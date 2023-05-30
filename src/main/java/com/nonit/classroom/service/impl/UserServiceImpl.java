package com.nonit.classroom.service.impl;

import com.nonit.classroom.service.mapper.UserMapper;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.entity.Gender;
import com.nonit.classroom.entity.Role;
import com.nonit.classroom.entity.User;
import com.nonit.classroom.entity.UserRoleAssignment;
import com.nonit.classroom.repository.UserRepository;
import com.nonit.classroom.service.UserService;
import com.nonit.classroom.service.dto.UserCreatingDTO;
import com.nonit.classroom.service.dto.UserDTO;
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
    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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
            throw ClassroomException.badRequest("InvalidInput",
                    "User's first name, last name and username must be filled");
        }

        if (userCreatingDTO.getUsername().length() >= 15) {
            throw ClassroomException.badRequest("InvalidUsername",
                    "User name must not be longer than 15 symbols");
        }

        if (userCreatingDTO.getPassword().length() > 24 || userCreatingDTO.getPassword().length() < 5) {
            throw ClassroomException.badRequest("InvalidPassword", "Password must contain 8 chars to 24 chars");
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
        logger.info("create user successfully");
        return UserMapper.USER_MAPPER.toDto(userRepository.save(user));
    }

    @Override
    public UserDTO updateUserByIdForAdmin(Long userId, UserCreatingDTO userCreatingDTO) {
        User user = userRepository.findById(userId).orElseThrow(ClassroomException::userNotFound);
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
        User user = userRepository.findById(userId).orElseThrow(ClassroomException::userNotFound);

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
        userRepository.findById(id).orElseThrow(ClassroomException::userNotFound);
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return UserMapper.USER_MAPPER.toDto(userRepository.findById(id).orElseThrow(ClassroomException::userNotFound));
    }

    @Override
    public UserDTO getUserByUserName(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> ClassroomException.badRequest("user_BAD_REQUEST", "user bad request"));
        if (userName.isBlank()) {
            throw ClassroomException.badRequest("user_BAD_REQUEST", "user bad request");
        }
        return UserMapper.USER_MAPPER.toDto(user);
    }

    @Override
    public List<UserDTO> getStudentsByClassroomId(Role role, Long classroomId) {
        return UserMapper.USER_MAPPER.toDtos(userRepository.getStudentsByClassroomId(role, classroomId));
    }

    @Override
    public List<UserDTO> importStudentsFromFile(MultipartFile file) throws IOException {
        List<User> students = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);
        logger.info("row number" + worksheet.getPhysicalNumberOfRows());
        for(int i = 1; i < worksheet.getPhysicalNumberOfRows() ; i++) {
            XSSFRow row = worksheet.getRow(i);
            if(row.getCell(1).getStringCellValue() == null) break;

            User student = new User();
            UserRoleAssignment userRoleAssignment = new UserRoleAssignment();

            student.setFirstName(row.getCell(1).getStringCellValue());
            student.setLastName(row.getCell(2).getStringCellValue());
            student.setEmail(row.getCell(3).getStringCellValue());
            student.setGender(Gender.valueOf(row.getCell(4).getStringCellValue()));
            student.setDateOfBirth(LocalDate.parse(row.getCell(5).getStringCellValue()));
            student.setAvatar(row.getCell(6).getStringCellValue());
            student.setUsername(row.getCell(7).getStringCellValue());
            student.setPassword(passwordEncoder.encode(row.getCell(8).getStringCellValue()));
            userRoleAssignment.setRole(Role.valueOf(row.getCell(9).getStringCellValue()));
            student.setUserRoleAssignment(userRoleAssignment);

            students.add(student);
        }

        List<User> savedStudents = userRepository.saveAll(students);

        return UserMapper.USER_MAPPER.toDtos(students);
    }
}
