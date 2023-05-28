package com.personalproject.companyclassroom.repository;

import com.personalproject.companyclassroom.entity.Classroom;
import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.customDTO.CustomClassroomDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    List<CustomClassroomDTO> findActiveClassesAndNumberOfStudents(Role role, LocalDate date);

    @Query(value = "SELECT c FROM Classroom c where c.course.id = :courseId")
    List<ClassroomDTO> getClassroomsByCourseId(@Param("courseId") Long courseId);
}
