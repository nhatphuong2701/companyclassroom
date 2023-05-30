package com.nonit.classroom.service;

import com.nonit.classroom.service.dto.ClassDTO;
import com.nonit.classroom.service.dto.CustomClassDTO;

import java.time.LocalDate;
import java.util.List;

public interface ClassService {

    List<ClassDTO> getAllClasses();

    ClassDTO createClass(ClassDTO classDTO);


    ClassDTO updateClass(Long classId, ClassDTO classDTO);

    void deleteClass(Long classId);

    List<CustomClassDTO> getActiveClassesAndNumberOfStudents(LocalDate date);

    List<ClassDTO> getClassesByCourseId(Long courseId);

    List<ClassDTO> getByEndDateBefore(LocalDate date);
}
