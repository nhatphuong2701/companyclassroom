package com.personalproject.companyclassroom.repository;
import com.personalproject.companyclassroom.entity.Participate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipateRepository extends JpaRepository<Participate, Long> {
}
