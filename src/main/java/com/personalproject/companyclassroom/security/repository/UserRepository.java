package com.personalproject.companyclassroom.security.repository;

import com.personalproject.companyclassroom.security.entity.Role;
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

    @Query(value = "SELECT u " +
            "FROM UserRoleAssignment r, User u, Participate p " +
            "WHERE r.role like :role AND u.id = p.user.id and " +
            "u.id = r.user.id and p.classroom.id = :classroomId")
    List<User> getStudentsByClassroomId(@Param("role") Role role, @Param("classroomId") Long classroomId);
}
