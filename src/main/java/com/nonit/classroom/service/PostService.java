package com.nonit.classroom.service;

import com.nonit.classroom.service.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createPost(PostDTO postDTO);

    PostDTO updatePost(Long postId, PostDTO postDTO);

    void deletePost(Long postId);

    List<PostDTO> searchPost(String keyword);
}
