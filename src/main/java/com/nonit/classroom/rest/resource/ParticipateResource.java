package com.nonit.classroom.rest.resource;

import com.nonit.classroom.rest.api.ParticipateAPI;
import com.nonit.classroom.service.ParticipateService;
import com.nonit.classroom.service.dto.ParticipateDTO;
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
    public ResponseEntity<ParticipateDTO> createParticipation(ParticipateDTO participateDTO) {
        ParticipateDTO newParticipation = participateService.createParticipation(participateDTO);
        return ResponseEntity.created(URI.create("/api/participation/" + newParticipation.getId()))
                .body(newParticipation);
    }

    @Override
    public ResponseEntity<ParticipateDTO> updateParticipation(Long participateId, ParticipateDTO participateDTO) {
        return ResponseEntity.ok().body(participateService.updateParticipation(participateId, participateDTO));
    }

    @Override
    public ResponseEntity<Void> deleteParticipationById(Long participateId) {
        participateService.deleteParticipation(participateId);
        return ResponseEntity.noContent().build();
    }
}
