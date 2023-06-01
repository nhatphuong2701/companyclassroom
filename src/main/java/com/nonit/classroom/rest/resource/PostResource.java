package com.nonit.classroom.rest.resource;

import com.nonit.classroom.rest.api.PostAPI;
import com.nonit.classroom.service.PostService;
import com.nonit.classroom.service.dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class PostResource implements PostAPI {

    @Autowired
    private PostService postService;

    @Override
    public ResponseEntity<List<PostDTO>> getAllPosts() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @Override
    public ResponseEntity<PostDTO> createPost(PostDTO postDTO) {
        PostDTO newPost = postService.createPost(postDTO);
        return ResponseEntity.created(URI.create("/api/posts/" + newPost.getId())).body(newPost);
    }

    @Override
    public ResponseEntity<PostDTO> updatePost(Long postId, PostDTO postDTO) {
        return ResponseEntity.ok().body(postService.updatePost(postId, postDTO));
    }

    @Override
    public ResponseEntity<Void> deletePost(Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<PostDTO>> searchPost(String keyword) {
        return ResponseEntity.ok(postService.searchPost(keyword));
    }
}
