package com.personalproject.companyclassroom.rest.api;

import com.personalproject.companyclassroom.service.dto.creatingDTO.ParticipateCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ParticipateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/participation")
public interface ParticipateAPI {

    @GetMapping
    ResponseEntity<List<ParticipateDTO>> getAllParticipation();

    @PostMapping
    ResponseEntity<ParticipateDTO> createParticipation(@RequestBody ParticipateCreatingDTO participateCreatingDTO);

    @PutMapping("/{participateId}")
    ResponseEntity<ParticipateDTO> updateParticipationById(@PathVariable("participateId") Long participateId,
                                                           @RequestBody ParticipateCreatingDTO participateCreatingDTO);

    @DeleteMapping("/{participateId}")
    void deleteParticipationById(@PathVariable("participateId") Long participateId);
}
