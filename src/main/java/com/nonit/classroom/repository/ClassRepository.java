package com.nonit.classroom.repository;

import com.nonit.classroom.entity.Clazz;
import com.nonit.classroom.service.dto.CustomClassDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Clazz, Long> {

    List<CustomClassDTO> findActiveClassesAndNumberOfStudents(LocalDate date);

    @Query(value = "SELECT c FROM Classroom c where c.course.id = :courseId")
    List<Clazz> getClassroomsByCourseId(@Param("courseId") Long courseId);

    List<Clazz> findByEndDateBefore(LocalDate date);
}
