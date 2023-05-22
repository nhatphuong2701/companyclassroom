package com.personalproject.companyclassroom.repository;
import com.personalproject.companyclassroom.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Long> {
}
