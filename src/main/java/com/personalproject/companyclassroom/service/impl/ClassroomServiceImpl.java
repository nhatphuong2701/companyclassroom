package com.personalproject.companyclassroom.service.impl;

import com.personalproject.companyclassroom.entity.Classroom;
import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.repository.ClassroomRepository;
import com.personalproject.companyclassroom.repository.CourseRepository;
import com.personalproject.companyclassroom.service.ClassroomService;
import com.personalproject.companyclassroom.service.dto.ClassroomCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomUpdatingDTO;
import com.personalproject.companyclassroom.service.mapper.ClassroomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<ClassroomDTO> getAllClassrooms() {
        return ClassroomMapper.CLASSROOM_MAPPER.toDtos(classroomRepository.findAll());
    }

    @Override
    public ClassroomDTO createClassroom(ClassroomCreatingDTO classroomCreatingDTO) {
        if (classroomCreatingDTO.getStartDate().isBefore(LocalDate.now()) ||
                classroomCreatingDTO.getEndDate().isBefore(classroomCreatingDTO.getStartDate())) {
            throw CompanyClassroomException.badRequest("InvalidClassroomDate",
                    "invalid start date or end date");
        }
        Classroom classroom = Classroom.builder()
                .name(classroomCreatingDTO.getName())
                .startDate(classroomCreatingDTO.getStartDate())
                .endDate(classroomCreatingDTO.getEndDate())
                .code(classroomCreatingDTO.getCode())
                .academicYear(classroomCreatingDTO.getAcademicYear())
                .course(courseRepository.findById(classroomCreatingDTO.getCourseId()).
                        orElseThrow(CompanyClassroomException::courseNotFound))
                .build();
        return ClassroomMapper.CLASSROOM_MAPPER.toDto(classroomRepository.save(classroom));
    }

    @Override
    public ClassroomDTO updateClassroomById(Long classroomId, ClassroomUpdatingDTO classroomUpdatingDTO) {
        Classroom updatedClassroom = classroomRepository.findById(classroomId).
        orElseThrow(CompanyClassroomException::classroomNotFound);
        updatedClassroom.setName(classroomUpdatingDTO.getName());
        updatedClassroom.setCourse(courseRepository.findById(classroomUpdatingDTO.getCourseId()).
                orElseThrow(CompanyClassroomException::courseNotFound));
        updatedClassroom.setAcademicYear(classroomUpdatingDTO.getAcademicYear());
        updatedClassroom.setStartDate(classroomUpdatingDTO.getStartDate());
        updatedClassroom.setEndDate(classroomUpdatingDTO.getEndDate());
        return ClassroomMapper.CLASSROOM_MAPPER.toDto(classroomRepository.save(updatedClassroom));
    }


    @Override
    public void deleteClassroomById(Long classroomId) {
        classroomRepository.findById(classroomId).orElseThrow(CompanyClassroomException::courseNotFound);
        classroomRepository.deleteById(classroomId);
    }
}
