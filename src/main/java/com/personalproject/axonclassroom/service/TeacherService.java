package com.personalproject.axonclassroom.service;

import com.personalproject.axonclassroom.entity.Teacher;
import com.personalproject.axonclassroom.service.dto.TeacherCreatingDTO;
import com.personalproject.axonclassroom.service.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getAllTeachers();

    TeacherDTO createTeacher(TeacherCreatingDTO teacherCreatingDTO);

    TeacherDTO updateTeacherById(Long id, TeacherCreatingDTO teacherCreatingDTO);

    TeacherDTO deleteTeacherById(Long id);


}
