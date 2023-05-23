package com.personalproject.companyclassroom.service;

import com.personalproject.companyclassroom.service.dto.PostCreatingDTO;
import com.personalproject.companyclassroom.service.dto.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> getAllPosts();

    PostDTO createPost (PostCreatingDTO postCreatingDTO);

    PostDTO updatePostById (Long postId, PostCreatingDTO postCreatingDTO);

    void deletePostById (Long postId);
}
