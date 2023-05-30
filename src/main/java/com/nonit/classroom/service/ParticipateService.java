package com.nonit.classroom.service;

import com.nonit.classroom.service.dto.ParticipateDTO;

import java.util.List;

public interface ParticipateService {

    List<ParticipateDTO> getAllParticipation();

    ParticipateDTO createParticipation(ParticipateDTO participateDTO);

    ParticipateDTO updateParticipation(Long participateId, ParticipateDTO participateDTO);

    void deleteParticipation(Long participateId);
}
