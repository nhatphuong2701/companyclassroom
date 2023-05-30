package com.nonit.classroom.service.impl;

import com.nonit.classroom.entity.Clazz;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.ClassRepository;
import com.nonit.classroom.repository.CourseRepository;
import com.nonit.classroom.service.ClassService;
import com.nonit.classroom.service.dto.ClassDTO;
import com.nonit.classroom.service.dto.CustomClassDTO;
import com.nonit.classroom.service.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassRepository classRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<ClassDTO> getAllClasses() {
        return ClassMapper.INSTANCE.toDtos(classRepository.findAll());
    }

    @Override
    public ClassDTO createClass(ClassDTO classDTO) {
        checkDTO(classDTO);
        Clazz clazz = Clazz.builder()
                .name(classDTO.getName())
                .startDate(classDTO.getStartDate())
                .endDate(classDTO.getEndDate())
                .academicYear(classDTO.getAcademicYear())
                .course(courseRepository.findById(classDTO.getCourseId()).
                        orElseThrow(ClassroomException::courseNotFound))
                .build();

        return ClassMapper.INSTANCE.toDto(classRepository.save(clazz));
    }


    @Override
    public ClassDTO updateClass(Long classId, ClassDTO classDTO) {
        Clazz updatedClass = classRepository.findById(classId).
                orElseThrow(ClassroomException::classroomNotFound);
        ClassMapper.INSTANCE.updateClassFromDTO(classDTO, updatedClass);
        return ClassMapper.INSTANCE.toDto(classRepository.save(updatedClass));
    }

    @Override
    public void deleteClass(Long classId) {
        classRepository.deleteById(classId);
    }

    @Override
    public List<CustomClassDTO> getActiveClassesAndNumberOfStudents(LocalDate date) {
        return classRepository.findActiveClassesAndNumberOfStudents(date);
    }

    @Override
    public List<ClassDTO> getClassesByCourseId(Long courseId) {
        return ClassMapper.INSTANCE.toDtos(classRepository.getClassroomsByCourseId(courseId));
    }

    @Override
    public List<ClassDTO> getByEndDateBefore(LocalDate date) {
        return ClassMapper.INSTANCE.toDtos(classRepository.findByEndDateBefore(date));
    }

    private static void checkDTO(ClassDTO classDTO) {
        if (classDTO.getStartDate().isBefore(LocalDate.now()) ||
                classDTO.getEndDate().isBefore(classDTO.getStartDate())) {
            throw ClassroomException.badRequest("InvalidClassroomDate",
                    "invalid start date or end date");
        }
    }
}
