package com.personalproject.companyclassroom.rest.api;


import com.personalproject.companyclassroom.service.dto.creatingDTO.PostCreatingDTO;
import com.personalproject.companyclassroom.service.dto.PostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/posts")
public interface PostAPI{
    @PreAuthorize(value = "hasRole('ADMIN')")
    @GetMapping
    ResponseEntity<List<PostDTO>> getAllPosts(PostCreatingDTO postCreatingDTO);

    @PreAuthorize(value = "hasAnyRole('TEACHER','ADMIN')")
    @PostMapping
    ResponseEntity<PostDTO> createPost(@RequestBody PostCreatingDTO postCreatingDTO);

    @PreAuthorize(value = "hasAnyRole('TEACHER','ADMIN')")
    @PutMapping("/{postId}")
    ResponseEntity<PostDTO> updatePostById(@PathVariable("postId") Long postId, @RequestBody PostCreatingDTO postCreatingDTO);

    @PreAuthorize(value = "hasAnyRole('TEACHER','ADMIN')")
    @DeleteMapping("/{postId}")
    void deleteById(@PathVariable("postId") Long postId);

    @PreAuthorize(value = "hasAnyRole('TEACHER','ADMIN','STUDENT')")
    @GetMapping("/search")
    ResponseEntity<List<PostDTO>> searchPost(@RequestParam("keyword") String keyword);
}
