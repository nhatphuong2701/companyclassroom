package com.personalproject.companyclassroom.rest;


import com.personalproject.companyclassroom.service.dto.PostCreatingDTO;
import com.personalproject.companyclassroom.service.dto.PostDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/posts")
public interface PostAPI{
    @GetMapping
    ResponseEntity<List<PostDTO>> getAllPosts(PostCreatingDTO postCreatingDTO);

    @PostMapping
    ResponseEntity<PostDTO> createPost(@RequestBody PostCreatingDTO postCreatingDTO);

    @PutMapping("/{postId}")
    ResponseEntity<PostDTO> updatePostById(@PathVariable("postId") Long postId, @RequestBody PostCreatingDTO postCreatingDTO);

    @DeleteMapping("/{postId}")
    void deleteById(@PathVariable("postId") Long postId);

}
