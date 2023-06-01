package com.nonit.classroom.repository;

import com.nonit.classroom.entity.Role;
import com.nonit.classroom.service.dto.CustomCourseDTO;
import com.nonit.classroom.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query(value = "SELECT new com.nonit.classroom.service.dto.CustomCourseDTO" +
            "(c.name, COUNT(DISTINCT (cl.id)), COUNT(u.id))" +
            "FROM Clazz cl, Course c, Participate p, User u, UserRoleAssignment ura " +
            "WHERE cl.course.id = c.id " +
            "AND p.clazz.id  = cl.id " +
            "AND p.user.id = u.id " +
            "AND ura.user.id = u.id " +
            "AND ura.role = 'ROLE_STUDENT' " +
            "GROUP BY c.name")
    List<CustomCourseDTO> findCoursesWithNumberOfClassesAndStudents();
}
