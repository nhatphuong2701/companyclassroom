package com.personalproject.axonclassroom.service.impl;

import com.personalproject.axonclassroom.entity.Teacher;
import com.personalproject.axonclassroom.exception.TeacherException;
import com.personalproject.axonclassroom.repository.TeacherRepository;
import com.personalproject.axonclassroom.service.TeacherService;
import com.personalproject.axonclassroom.service.dto.TeacherCreatingDTO;
import com.personalproject.axonclassroom.service.dto.TeacherDTO;
import com.personalproject.axonclassroom.service.dto.TeacherUpdatingDTO;
import com.personalproject.axonclassroom.service.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository teacherRepository;

    @Override
    public List<TeacherDTO> getAllTeachers () {
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
                .build();
        return TeacherMapper.TEACHER_MAPPER.toDto(teacherRepository.save(teacher));
    }

    @Override
    public TeacherDTO updateTeacherById(Long id, TeacherUpdatingDTO teacherUpdatingDTO) {
        Teacher teacher = teacherRepository.findById(id).get();
        if (id == null) {
            throw TeacherException.badRequest("TEACHER_BAD_REQUEST", "bad request");
        } else {
            Teacher updatedTeacher = teacher;
            updatedTeacher.setFirstName(teacherUpdatingDTO.getFirstName());
            updatedTeacher.setLastName(teacherUpdatingDTO.getLastName());
            updatedTeacher.setEmail(teacherUpdatingDTO.getEmail());
            return TeacherMapper.TEACHER_MAPPER.toDto(teacherRepository.save(teacher));
        }
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }
}
