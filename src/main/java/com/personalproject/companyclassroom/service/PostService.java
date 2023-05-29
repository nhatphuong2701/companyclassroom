package com.personalproject.companyclassroom.service;

import com.personalproject.companyclassroom.service.dto.creatingDTO.PostCreatingDTO;
import com.personalproject.companyclassroom.service.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createPost (PostCreatingDTO postCreatingDTO);

    PostDTO updatePostById (Long postId, PostCreatingDTO postCreatingDTO);

    void deletePostById (Long postId);

    List<PostDTO> searchPost(String keyword);
}
