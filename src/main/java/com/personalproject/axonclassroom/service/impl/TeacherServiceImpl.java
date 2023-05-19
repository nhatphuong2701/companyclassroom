package com.personalproject.axonclassroom.service.impl;

import com.personalproject.axonclassroom.entity.Teacher;
import com.personalproject.axonclassroom.exception.AxonClassroomException;
import com.personalproject.axonclassroom.exception.ResponseException;
import com.personalproject.axonclassroom.repository.TeacherRepository;
import com.personalproject.axonclassroom.service.TeacherService;
import com.personalproject.axonclassroom.service.dto.TeacherCreatingDTO;
import com.personalproject.axonclassroom.service.dto.TeacherDTO;
import com.personalproject.axonclassroom.service.dto.TeacherUpdatingDTO;
import com.personalproject.axonclassroom.service.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return TeacherMapper.TEACHER_MAPPER.toDtos(teacherRepository.findAll());
    }

    @Override
    public TeacherDTO createTeacher(TeacherCreatingDTO teacherCreatingDTO) {
        Teacher teacher = Teacher.builder()
                .firstName(teacherCreatingDTO.getFirstName())
                .lastName(teacherCreatingDTO.getLastName())
                .password(teacherCreatingDTO.getPassword())
                .username(teacherCreatingDTO.getUsername())
                .email(teacherCreatingDTO.getEmail())
                .avatar(teacherCreatingDTO.getAvatar())
                .build();
        return TeacherMapper.TEACHER_MAPPER.toDto(teacherRepository.save(teacher));
    }

    @Override
    public TeacherDTO updateTeacherById(Long id, TeacherUpdatingDTO teacherUpdatingDTO) {
        Teacher teacher = teacherRepository.findById(id).orElseThrow(AxonClassroomException::entityNotFound);
        teacher.setFirstName(teacherUpdatingDTO.getFirstName());
        teacher.setLastName(teacherUpdatingDTO.getLastName());
        teacher.setEmail(teacherUpdatingDTO.getEmail());
        teacher.setUsername(teacherUpdatingDTO.getUsername());
        teacher.setPassword(teacherUpdatingDTO.getPassword());
        return TeacherMapper.TEACHER_MAPPER.toDto(teacherRepository.save(teacher));
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.findById(id).orElseThrow(AxonClassroomException::entityNotFound);
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherDTO getTeacherById(Long id) {
        return TeacherMapper.TEACHER_MAPPER.toDto(teacherRepository.findById(id).orElseThrow(AxonClassroomException::entityNotFound));
    }

    @Override
    public List<TeacherDTO> getTeacherByUserName(String userName) {
        List<Teacher> teachers = teacherRepository.findByUsername(userName);
        if (userName == null || userName.isBlank()) {
            throw AxonClassroomException.badRequest("TEACHER_BAD_REQUEST", "Teacher bad request");
        }
        return TeacherMapper.TEACHER_MAPPER.toDtos(teachers);
    }
}
