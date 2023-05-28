package com.personalproject.companyclassroom.rest.resource;

import com.personalproject.companyclassroom.rest.api.ParticipateAPI;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import com.personalproject.companyclassroom.service.ParticipateService;
import com.personalproject.companyclassroom.service.dto.creatingDTO.ParticipateCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ParticipateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class ParticipateResource implements ParticipateAPI {
    @Autowired
    private ParticipateService participateService;

    @Override
    public ResponseEntity<List<ParticipateDTO>> getAllParticipation() {
        return ResponseEntity.ok(participateService.getAllParticipation());
    }

    @Override
    public ResponseEntity<ParticipateDTO> createParticipation(ParticipateCreatingDTO participateCreatingDTO) {
        ParticipateDTO newParticipation = participateService.createParticipation(participateCreatingDTO);
        return ResponseEntity.created(URI.create("/api/participation/" + newParticipation.getId())).body(newParticipation);
    }

    @Override
    public ResponseEntity<ParticipateDTO> updateParticipationById(Long participateId, ParticipateCreatingDTO participateCreatingDTO) {
        return ResponseEntity.ok().body(participateService.updateParticipationById(participateId, participateCreatingDTO));
    }

    @Override
    public void deleteParticipationById(Long participateId) {
        participateService.deleteParticipationById(participateId);
        ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<UserDTO>> getStudentsByClassroomId(Long classroomId) {
        return null;
    }
}
