package com.nonit.classroom.service.impl;

import com.nonit.classroom.repository.UserRepository;
import com.nonit.classroom.service.dto.creatingDTO.ParticipateCreatingDTO;
import com.nonit.classroom.service.mapper.ParticipateMapper;
import com.nonit.classroom.entity.Participate;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.ClassRepository;
import com.nonit.classroom.repository.ParticipateRepository;
import com.nonit.classroom.service.ParticipateService;
import com.nonit.classroom.service.dto.ParticipateDTO;
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
        return ParticipateMapper.PARTICIPATE_MAPPER.toDtos(participateRepository.findAll());
    }

    @Override
    public ParticipateDTO createParticipation(ParticipateCreatingDTO participateCreatingDTO) {
        Participate newParticipate = Participate.builder()
                .user(userRepository.findById(participateCreatingDTO.getUserId()).
                        orElseThrow(ClassroomException::userNotFound))
                .clazz(classRepository.findById(participateCreatingDTO.getClassroomId()).
                        orElseThrow(ClassroomException::classroomNotFound))
                .build();
        return ParticipateMapper.PARTICIPATE_MAPPER.toDto(participateRepository.save(newParticipate));
    }

    @Override
    public ParticipateDTO updateParticipationById(Long participateId, ParticipateCreatingDTO participateCreatingDTO) {
        Participate updateParticipate = participateRepository.findById(participateId).
                orElseThrow(ClassroomException::participationNotFound);
        updateParticipate.setUser(userRepository.findById(participateCreatingDTO.getUserId()).
                orElseThrow(ClassroomException::userNotFound));
        updateParticipate.setClazz(classRepository.findById(participateCreatingDTO.getClassroomId()).
                orElseThrow(ClassroomException::classroomNotFound));
        return ParticipateMapper.PARTICIPATE_MAPPER.toDto(participateRepository.save(updateParticipate));
    }

    @Override
    public void deleteParticipationById(Long participateId) {
        participateRepository.findById(participateId);
        participateRepository.deleteById(participateId);
    }
}
