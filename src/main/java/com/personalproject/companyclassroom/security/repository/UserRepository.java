package com.personalproject.companyclassroom.security.repository;

import com.personalproject.companyclassroom.security.entity.User;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    @Query(value = "SELECT (SELECT r.user FROM UserRoleAssignment r where r.role like 'ROLE_STUDENT') " +
            "FROM User u, Participate p where u.id = p.userId and p.classroomId = :classroomId")
    List<UserDTO> getStudentsByClassroomId(@Param("classroomId") Long classroomId);
}
