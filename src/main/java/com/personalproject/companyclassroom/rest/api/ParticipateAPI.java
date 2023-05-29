package com.personalproject.companyclassroom.rest.api;

import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import com.personalproject.companyclassroom.service.dto.creatingDTO.ParticipateCreatingDTO;
import com.personalproject.companyclassroom.service.dto.ParticipateDTO;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/participation")
public interface ParticipateAPI {
    @PreAuthorize(value = "hasAnyRole('ADMIN','TEACHER','STUDENT')")
    @GetMapping
    ResponseEntity<List<ParticipateDTO>> getAllParticipation();

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PostMapping
    ResponseEntity<ParticipateDTO> createParticipation(@RequestBody ParticipateCreatingDTO participateCreatingDTO);

    @PreAuthorize(value = "hasRole('ADMIN')")
    @PutMapping("/{participateId}")
    ResponseEntity<ParticipateDTO> updateParticipationById(@PathVariable("participateId") Long participateId,
                                                           @RequestBody ParticipateCreatingDTO participateCreatingDTO);
    @PreAuthorize(value = "hasRole('ADMIN')")
    @DeleteMapping("/{participateId}")
    void deleteParticipationById(@PathVariable("participateId") Long participateId);
}
