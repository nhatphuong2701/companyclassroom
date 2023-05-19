package com.personalproject.axonclassroom.service;
import com.personalproject.axonclassroom.service.dto.TeacherCreatingDTO;
import com.personalproject.axonclassroom.service.dto.TeacherDTO;
import com.personalproject.axonclassroom.service.dto.TeacherUpdatingDTO;

import java.util.List;

public interface TeacherService {
    List<TeacherDTO> getAllTeachers();

    TeacherDTO createTeacher(TeacherCreatingDTO teacherCreatingDTO);

    TeacherDTO updateTeacherById(Long teacherId, TeacherUpdatingDTO teacherUpdatingDTO);

    void deleteTeacherById(Long id);

    TeacherDTO getTeacherById(Long id);

    List<TeacherDTO> getTeacherByUserName(String userName);

}
