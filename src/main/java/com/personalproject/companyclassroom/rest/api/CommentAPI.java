package com.personalproject.companyclassroom.rest.api;

import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.creatingDTO.CommentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.CommentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/comments")
public interface CommentAPI {

    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping
    ResponseEntity<List<CommentDTO>> getAllComments();

    @PreAuthorize(value = "hasAnyRole('ADMIN','TEACHER','STUDENT')")
    @PostMapping
    ResponseEntity<CommentDTO> createComment(@RequestBody CommentCreatingDTO commentCreatingDTO);

    @PreAuthorize(value = "hasAnyRole('TEACHER','STUDENT')")
    @PutMapping("/{commentId}")
    ResponseEntity<CommentDTO> updateCommentById(@PathVariable("commentId") Long commentId, @RequestBody CommentCreatingDTO commentCreatingDTO);

    @PreAuthorize(value = "hasAnyRole('ADMIN','TEACHER','STUDENT')")
    @DeleteMapping("/{commentId}")
    void deleteCommentById(@PathVariable("commentId") Long commentId);

    @PreAuthorize(value = "hasAnyRole('ADMIN','TEACHER','STUDENT')")
    @GetMapping("/comment-from-post")
    ResponseEntity<List<CommentDTO>> findByPost(@RequestParam("postId") Long postId);

}
