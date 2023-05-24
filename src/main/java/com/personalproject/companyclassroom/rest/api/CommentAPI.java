package com.personalproject.companyclassroom.rest.api;

import com.personalproject.companyclassroom.service.dto.creatingDTO.CommentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.CommentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/comments")
public interface CommentAPI {
    @GetMapping
    ResponseEntity<List<CommentDTO>> getAllComments();

    @PostMapping
    ResponseEntity<CommentDTO> createComment(@RequestBody CommentCreatingDTO commentCreatingDTO);

    @PutMapping("/{commentId}")
    ResponseEntity<CommentDTO> updateCommentById(@PathVariable("commentId") Long commentId, @RequestBody CommentCreatingDTO commentCreatingDTO);

    @DeleteMapping("/{commentId}")
    void deleteCommentById(@PathVariable("commentId") Long commentId);

}
