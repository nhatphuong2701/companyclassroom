package com.nonit.classroom.rest.api;

import com.nonit.classroom.service.dto.PostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.nonit.classroom.constant.AuthorityConstants.*;

@RequestMapping("/api/posts")
public interface PostAPI {

    @PreAuthorize(HAS_ROLE_ADMIN)
    @GetMapping
    ResponseEntity<List<PostDTO>> getAllPosts();

    @PreAuthorize(HAS_ROLE_TEACHER_ADMIN)
    @PostMapping
    ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO);

    @PreAuthorize(HAS_ROLE_TEACHER_ADMIN)
    @PutMapping("/{postId}")
    ResponseEntity<PostDTO> updatePost(@PathVariable Long postId, @RequestBody PostDTO postDTO);

    @PreAuthorize(HAS_ROLE_TEACHER_ADMIN)
    @DeleteMapping("/{postId}")
    ResponseEntity<Void> deletePost(@PathVariable Long postId);

    @PreAuthorize(HAS_ANY_ROLE)
    @GetMapping("/search")
    ResponseEntity<List<PostDTO>> searchPost(@RequestParam("keyword") String keyword);
}
