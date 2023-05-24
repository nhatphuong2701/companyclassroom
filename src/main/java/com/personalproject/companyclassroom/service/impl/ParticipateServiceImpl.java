package com.personalproject.companyclassroom.service.impl;

import com.personalproject.companyclassroom.entity.Participate;
import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.repository.ClassroomRepository;
import com.personalproject.companyclassroom.repository.ParticipateRepository;
import com.personalproject.companyclassroom.security.repository.UserRepository;
import com.personalproject.companyclassroom.service.ParticipateService;
import com.personalproject.companyclassroom.service.dto.ParticipateCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ParticipateDTO;
import com.personalproject.companyclassroom.service.mapper.ParticipateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipateServiceImpl implements ParticipateService {

    private final ParticipateRepository participateRepository;
    private final UserRepository userRepository;
    private final ClassroomRepository classroomRepository;

    @Override
    public List<ParticipateDTO> getAllParticipation() {
        return ParticipateMapper.PARTICIPATE_MAPPER.toDtos(participateRepository.findAll());
    }

    @Override
    public ParticipateDTO createParticipation(ParticipateCreatingDTO participateCreatingDTO) {
        Participate newParticipate = Participate.builder()
                .user(userRepository.findById(participateCreatingDTO.getUserId()).orElseThrow(CompanyClassroomException::userNotFound))
                .classroom(classroomRepository.findById(participateCreatingDTO.getClassroomId()).orElseThrow(CompanyClassroomException::classroomNotFound))
                .build();
        return ParticipateMapper.PARTICIPATE_MAPPER.toDto(participateRepository.save(newParticipate));
    }

    @Override
    public ParticipateDTO updateParticipationById(Long participateId, ParticipateCreatingDTO participateCreatingDTO) {
        Participate updateParticipate = new Participate();
        updateParticipate.setUser(userRepository.findById(participateCreatingDTO.getUserId()).orElseThrow(CompanyClassroomException::userNotFound));
        updateParticipate.setClassroom(classroomRepository.findById(participateCreatingDTO.getClassroomId()).orElseThrow(CompanyClassroomException::classroomNotFound));
        return ParticipateMapper.PARTICIPATE_MAPPER.toDto(participateRepository.save(updateParticipate));
    }

    @Override
    public void deleteParticipationById(Long participateId) {
        participateRepository.findById(participateId);
        participateRepository.deleteById(participateId);
    }
}
