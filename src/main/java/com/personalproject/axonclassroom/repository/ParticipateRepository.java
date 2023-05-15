package com.personalproject.axonclassroom.repository;

import com.personalproject.axonclassroom.entity.Participate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipateRepository extends JpaRepository<Participate, Long> {
}
