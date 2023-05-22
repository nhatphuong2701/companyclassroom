package com.personalproject.companyclassroom.service.impl;

import com.personalproject.companyclassroom.entity.Classroom;
import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.repository.ClassroomRepository;
import com.personalproject.companyclassroom.repository.CourseRepository;
import com.personalproject.companyclassroom.service.dto.ClassroomCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomUpdatingDTO;
import com.personalproject.companyclassroom.service.mapper.ClassroomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl {
    private final ClassroomRepository classroomRepository;
    private final CourseRepository courseRepository;

    public List<ClassroomDTO> getAllClassrooms() {
        return ClassroomMapper.CLASSROOM_MAPPER.toDtos(classroomRepository.findAll());
    }

    public ClassroomDTO createClassroom(ClassroomCreatingDTO classroomCreatingDTO) {
        Classroom classroom = Classroom.builder()
                .name(classroomCreatingDTO.getName())
                .startDate(classroomCreatingDTO.getStartDate())
                .endDate(classroomCreatingDTO.getEndDate())
                .code(classroomCreatingDTO.getCode())
                .academicYear(classroomCreatingDTO.getAcademicYear())
                .course(courseRepository.findById(classroomCreatingDTO.getCourseId()).orElseThrow(CompanyClassroomException::courseNotFound))
                .build();
        return ClassroomMapper.CLASSROOM_MAPPER.toDto(classroomRepository.save(classroom));
    }

    public ClassroomDTO updateClassroomById(Long classroomId, ClassroomUpdatingDTO classroomUpdatingDTO) {
        Classroom updatedClassroom = classroomRepository.findById(classroomId).orElseThrow(CompanyClassroomException::classroomNotFound);
        updatedClassroom.setName(classroomUpdatingDTO.getName());
        updatedClassroom.setCourse(courseRepository.findById(classroomUpdatingDTO.getCourseId()).orElseThrow(CompanyClassroomException::courseNotFound));
        updatedClassroom.setAcademicYear(classroomUpdatingDTO.getAcademicYear());
        updatedClassroom.setStartDate(classroomUpdatingDTO.getStartDate());
        updatedClassroom.setEndDate(classroomUpdatingDTO.getEndDate());
        return ClassroomMapper.CLASSROOM_MAPPER.toDto(classroomRepository.save(updatedClassroom));
    }

    public void deleteClassroomById(Long classroomId) {
        classroomRepository.findById(classroomId).orElseThrow(CompanyClassroomException::courseNotFound);
        classroomRepository.deleteById(classroomId);
    }
}
