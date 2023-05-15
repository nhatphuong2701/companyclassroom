package com.personalproject.axonclassroom.repository;
import com.personalproject.axonclassroom.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Long> {
}
