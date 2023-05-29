package com.personalproject.companyclassroom.repository;

import com.personalproject.companyclassroom.entity.Course;
import com.personalproject.companyclassroom.security.entity.Role;
import com.personalproject.companyclassroom.service.dto.CourseDTO;
import com.personalproject.companyclassroom.service.dto.customDTO.CustomCourseDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(value = "SELECT new com.personalproject.companyclassroom.service.dto.customDTO.CustomCourseDTO(c.name, COUNT(DISTINCT (cl.id)), COUNT(u.id))" +
            "FROM Classroom cl, Course c, Participate p, User u, UserRoleAssignment ura " +
            "WHERE cl.course.id = c.id " +
            "AND p.classroom.id  = cl.id " +
            "AND p.user.id = u.id " +
            "AND ura.user.id = u.id " +
            "AND ura.role = :studentRole " +
            "GROUP BY c.name")
    List<CustomCourseDTO> getCourseWithNumberOfClassesAndStudents(@Param("studentRole")Role studentRole);
}
