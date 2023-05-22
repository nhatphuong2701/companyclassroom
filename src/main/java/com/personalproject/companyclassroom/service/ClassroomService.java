package com.personalproject.companyclassroom.service;

import com.personalproject.companyclassroom.service.dto.ClassroomCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;

import java.util.List;

public interface ClassroomService {
    List<ClassroomDTO> getAllClassrooms();

    ClassroomDTO createClassroom(ClassroomCreatingDTO classroomCreatingDTO);

    ClassroomDTO updateClassroomById(Long classroomId, ClassroomCreatingDTO classroomCreatingDTO);

    void deleteClassroomByID(Long classroomId);
}
