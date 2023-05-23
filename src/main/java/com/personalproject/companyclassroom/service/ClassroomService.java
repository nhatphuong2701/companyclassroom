package com.personalproject.companyclassroom.service;

import com.personalproject.companyclassroom.service.dto.ClassroomCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomUpdatingDTO;

import java.util.List;

public interface ClassroomService {
    List<ClassroomDTO> getAllClassrooms();

    ClassroomDTO createClassroom(ClassroomCreatingDTO classroomCreatingDTO);


    ClassroomDTO updateClassroomById(Long classroomId, ClassroomUpdatingDTO classroomUpdatingDTO);

    void deleteClassroomById(Long classroomId);
}
