package com.nonit.classroom.repository;

import com.nonit.classroom.entity.Assignment;
import com.nonit.classroom.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

    @Query(value = "SELECT u FROM Submission s, User u WHERE s.user.id = u.id and s.assignment.id = :assignmentId")
    List<User> getStudentHasNoSubmissionByAssignmentId(@Param("assignmentId") Long assignmentID);

    @Query(value = "SELECT u FROM User u WHERE u.id not in " +
            "(SELECT s.user.id FROM Submission s WHERE s.assignment.id = :assignmentId)")
    List<User> getStudentHasSubmissionByAssignmentId(@Param("assignmentId") Long assignmentID);
}
