package com.nonit.classroom.service.impl;

import com.nonit.classroom.entity.Participate;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.ClassRepository;
import com.nonit.classroom.repository.ParticipateRepository;
import com.nonit.classroom.repository.UserRepository;
import com.nonit.classroom.service.ParticipateService;
import com.nonit.classroom.service.dto.ParticipateDTO;
import com.nonit.classroom.service.mapper.ParticipateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipateServiceImpl implements ParticipateService {

    @Autowired
    private ParticipateRepository participateRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClassRepository classRepository;

    @Override
    public List<ParticipateDTO> getAllParticipation() {
        return ParticipateMapper.INSTANCE.toDtos(participateRepository.findAll());
    }

    @Override
    public ParticipateDTO createParticipation(ParticipateDTO participateDTO) {
        Participate newParticipate = Participate.builder()
                .user(userRepository.findById(participateDTO.getUserId()).
                        orElseThrow(ClassroomException::userNotFound))
                .clazz(classRepository.findById(participateDTO.getClassId()).
                        orElseThrow(ClassroomException::classroomNotFound))
                .build();
        return ParticipateMapper.INSTANCE.toDto(participateRepository.save(newParticipate));
    }

    @Override
    public ParticipateDTO updateParticipation(Long participateId, ParticipateDTO participateDTO) {
        Participate updatedParticipate = participateRepository.findById(participateId).
                orElseThrow(ClassroomException::participationNotFound);
        ParticipateMapper.INSTANCE.updateParticipationFromDTO(participateDTO, updatedParticipate);
        return ParticipateMapper.INSTANCE.toDto(participateRepository.save(updatedParticipate));
    }

    @Override
    public void deleteParticipation(Long participateId) {
        participateRepository.deleteById(participateId);
    }
}
