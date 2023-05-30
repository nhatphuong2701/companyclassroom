package com.nonit.classroom.rest.api;

import com.nonit.classroom.service.dto.ParticipateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nonit.classroom.constant.AuthorityConstants.HAS_ANY_ROLE;
import static com.nonit.classroom.constant.AuthorityConstants.HAS_ROLE_ADMIN;

@RequestMapping("/api/participation")
public interface ParticipateAPI {

    @PreAuthorize(HAS_ANY_ROLE)
    @GetMapping
    ResponseEntity<List<ParticipateDTO>> getAllParticipation();

    @PreAuthorize(HAS_ROLE_ADMIN)
    @PostMapping
    ResponseEntity<ParticipateDTO> createParticipation(@RequestBody ParticipateDTO participateDTO);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @PutMapping("/{participateId}")
    ResponseEntity<ParticipateDTO> updateParticipation(@PathVariable Long participateId,
                                                       @RequestBody ParticipateDTO participateDTO);

    @PreAuthorize(HAS_ROLE_ADMIN)
    @DeleteMapping("/{participateId}")
    ResponseEntity<Void> deleteParticipationById(@PathVariable Long participateId);
}
