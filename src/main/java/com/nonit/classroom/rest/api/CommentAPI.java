package com.nonit.classroom.rest.api;

import com.nonit.classroom.service.dto.CommentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nonit.classroom.constant.AuthorityConstants.*;

@RequestMapping("/api/comments")
public interface CommentAPI {

    @PreAuthorize(HAS_ROLE_ADMIN)
    @GetMapping
    ResponseEntity<List<CommentDTO>> getAllComments();

    @PreAuthorize(HAS_ANY_ROLE)
    @PostMapping
    ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO);

    @PreAuthorize(HAS_ROLE_TEACHER_STUDENT)
    @PutMapping("/{commentId}")
    ResponseEntity<CommentDTO> updateCommentById(@PathVariable Long commentId, @RequestBody CommentDTO commentDTO);

    @PreAuthorize(HAS_ANY_ROLE)
    @DeleteMapping("/{commentId}")
    ResponseEntity<Void> deleteCommentById(@PathVariable Long commentId);

    @PreAuthorize(HAS_ANY_ROLE)
    @GetMapping("/comment-from-post")
    ResponseEntity<List<CommentDTO>> getCommentByPostId(@RequestParam Long postId);

}
