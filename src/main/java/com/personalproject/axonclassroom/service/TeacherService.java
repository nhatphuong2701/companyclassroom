package com.personalproject.axonclassroom.service;

import com.personalproject.axonclassroom.entity.Teacher;
import com.personalproject.axonclassroom.repository.TeacherRepository;
import com.personalproject.axonclassroom.service.dto.TeacherDTO;
import com.personalproject.axonclassroom.service.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<TeacherDTO> getAllTeachers() {
        return TeacherMapper.TEACHER_MAPPER.toDtos(teacherRepository.findAll());
    }

    public TeacherDTO createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();

        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setLastName(teacherDTO.getLastName());
        teacher.setUsername(teacherDTO.getUsername());
        teacher.setEmail(teacherDTO.getEmail());
        teacher.setPassword(teacherDTO.getPassword());
        teacher.setAvatar(teacherDTO.getAvatar());
        return teacherRepository.save(teacherDTO);
    }
}
