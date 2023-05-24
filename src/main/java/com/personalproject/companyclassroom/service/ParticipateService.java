package com.personalproject.companyclassroom.service;

import com.personalproject.companyclassroom.service.dto.creatingDTO.ParticipateCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ParticipateDTO;

import java.util.List;

public interface ParticipateService {

    List<ParticipateDTO> getAllParticipation();

    ParticipateDTO createParticipation(ParticipateCreatingDTO participateCreatingDTO);

    ParticipateDTO updateParticipationById(Long participateId, ParticipateCreatingDTO participateCreatingDTO);

    void deleteParticipationById(Long participateId);
}
