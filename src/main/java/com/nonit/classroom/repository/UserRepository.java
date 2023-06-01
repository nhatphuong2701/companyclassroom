package com.nonit.classroom.repository;

import com.nonit.classroom.entity.Role;
import com.nonit.classroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    @Query(value = "SELECT u " +
            "FROM UserRoleAssignment r, User u, Participate p " +
            "WHERE u.id = r.user.id AND u.id = p.user.id " +
            "AND r.role = 'ROLE_STUDENT' AND p.clazz.id = :classId")
    List<User> getStudentsByClassroomId(@Param("classId") Long classId);
}
