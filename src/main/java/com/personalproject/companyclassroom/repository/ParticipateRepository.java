package com.personalproject.companyclassroom.repository;
import com.personalproject.companyclassroom.entity.Participate;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipateRepository extends JpaRepository<Participate, Long> {

}
