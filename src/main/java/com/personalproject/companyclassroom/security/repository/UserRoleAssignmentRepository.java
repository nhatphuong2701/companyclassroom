package com.personalproject.companyclassroom.security.repository;

import com.personalproject.companyclassroom.security.entity.UserRoleAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleAssignmentRepository extends JpaRepository<UserRoleAssignment, Long> {
}
