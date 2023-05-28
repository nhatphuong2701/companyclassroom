package com.personalproject.companyclassroom.service;

import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.service.dto.creatingDTO.ClassroomCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomUpdatingDTO;
import com.personalproject.companyclassroom.service.dto.customDTO.CustomClassroomDTO;

import java.time.LocalDate;
import java.util.List;

public interface ClassroomService {
    List<ClassroomDTO> getAllClassrooms();

    ClassroomDTO createClassroom(ClassroomCreatingDTO classroomCreatingDTO);


    ClassroomDTO updateClassroomById(Long classroomId, ClassroomUpdatingDTO classroomUpdatingDTO);

    void deleteClassroomById(Long classroomId);

    List<CustomClassroomDTO> findActiveClassesAndNumberOfStudents(Role role, LocalDate date);

    List<ClassroomDTO> getClassroomsByCourseId(Long courseId);
}
