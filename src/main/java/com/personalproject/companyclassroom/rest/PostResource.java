package com.personalproject.companyclassroom.rest;

import com.personalproject.companyclassroom.service.PostService;
import com.personalproject.companyclassroom.service.dto.PostCreatingDTO;
import com.personalproject.companyclassroom.service.dto.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostResource implements PostAPI{

    private final PostService postService;

    @Override
    public ResponseEntity<List<PostDTO>> getAllPosts(PostCreatingDTO postCreatingDTO) {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @Override
    public ResponseEntity<PostDTO> createPost(PostCreatingDTO postCreatingDTO) {
        PostDTO newPost = postService.createPost(postCreatingDTO);
        return ResponseEntity.created(URI.create("/api/posts/" + newPost.getId())).body(newPost);
    }

    @Override
    public ResponseEntity<PostDTO> updatePostById(Long postId, PostCreatingDTO postCreatingDTO) {
        return ResponseEntity.ok().body(postService.updatePostById(postId, postCreatingDTO));
    }

    @Override
    public void deleteById(Long postId) {
        postService.deletePostById(postId);
        ResponseEntity.noContent().build();
    }
}
