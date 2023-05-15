package com.personalproject.axonclassroom.repository;

import com.personalproject.axonclassroom.entity.Teach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachRepository extends JpaRepository<Teach,Long> {
}
