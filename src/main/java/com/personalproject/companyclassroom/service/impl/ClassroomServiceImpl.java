package com.personalproject.companyclassroom.service.impl;

import com.personalproject.companyclassroom.entity.Classroom;
import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.repository.ClassroomRepository;
import com.personalproject.companyclassroom.repository.CourseRepository;
import com.personalproject.companyclassroom.service.ClassroomService;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.ClassroomUpdatingDTO;
import com.personalproject.companyclassroom.service.dto.creatingDTO.ClassroomCreatingDTO;
import com.personalproject.companyclassroom.service.mapper.ClassroomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Service
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
        Random random = new Random();
        Classroom classroom = Classroom.builder()
                .name(classroomCreatingDTO.getName())
                .startDate(classroomCreatingDTO.getStartDate())
                .endDate(classroomCreatingDTO.getEndDate())
                .academicYear(classroomCreatingDTO.getAcademicYear())
                .course(courseRepository.findById(classroomCreatingDTO.getCourseId()).
                        orElseThrow(CompanyClassroomException::courseNotFound))
                .entryCode(random.nextLong())
                .build();
        return ClassroomMapper.CLASSROOM_MAPPER.toDto(classroomRepository.save(classroom));
    }

    @Override
    public ClassroomDTO updateClassroomById(Long classroomId, ClassroomUpdatingDTO classroomUpdatingDTO) {
        Classroom updatedClassroom = classroomRepository.findById(classroomId).
                orElseThrow(CompanyClassroomException::classroomNotFound);

        if(classroomUpdatingDTO.getName() != null)
            updatedClassroom.setName(classroomUpdatingDTO.getName());
        if(classroomUpdatingDTO.getCourseId() != null)
            updatedClassroom.setCourse(courseRepository.findById(classroomUpdatingDTO.getCourseId()).
                orElseThrow(CompanyClassroomException::courseNotFound));
        if(classroomUpdatingDTO.getAcademicYear() != null)
            updatedClassroom.setAcademicYear(classroomUpdatingDTO.getAcademicYear());
        if(classroomUpdatingDTO.getStartDate() != null)
            updatedClassroom.setStartDate(classroomUpdatingDTO.getStartDate());
        if(classroomUpdatingDTO.getEndDate() != null)
            updatedClassroom.setEndDate(classroomUpdatingDTO.getEndDate());
        return ClassroomMapper.CLASSROOM_MAPPER.toDto(classroomRepository.save(updatedClassroom));
    }


    @Override
    public void deleteClassroomById(Long classroomId) {
        classroomRepository.findById(classroomId).orElseThrow(CompanyClassroomException::courseNotFound);
        classroomRepository.deleteById(classroomId);
    }
}
