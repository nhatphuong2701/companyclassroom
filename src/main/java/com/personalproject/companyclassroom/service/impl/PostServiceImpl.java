package com.personalproject.companyclassroom.service.impl;

import com.personalproject.companyclassroom.entity.Post;
import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.repository.ClassroomRepository;
import com.personalproject.companyclassroom.repository.PostRepository;
import com.personalproject.companyclassroom.security.repository.UserRepository;
import com.personalproject.companyclassroom.service.PostService;
import com.personalproject.companyclassroom.service.dto.creatingDTO.PostCreatingDTO;
import com.personalproject.companyclassroom.service.dto.PostDTO;
import com.personalproject.companyclassroom.service.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public List<PostDTO> getAllPosts() {
        return PostMapper.POST_MAPPER.toDtos(postRepository.findAll());
    }

    @Override
    public PostDTO createPost(PostCreatingDTO postCreatingDTO) {
        Post post = Post.builder()
                .title(postCreatingDTO.getTitle())
                .content(postCreatingDTO.getContent())
                .attachment(postCreatingDTO.getAttachment())
                .user(userRepository.findById(postCreatingDTO.getUserId()).
                        orElseThrow(CompanyClassroomException::userNotFound))
                .classroom(classroomRepository.findById(postCreatingDTO.getClassroomId()).
                        orElseThrow(CompanyClassroomException::classroomNotFound))
                .build();
        return PostMapper.POST_MAPPER.toDto(postRepository.save(post));
    }

    @Override
    public PostDTO updatePostById(Long postId, PostCreatingDTO postCreatingDTO) {
        Post updatedPost = postRepository.findById(postId).orElseThrow(CompanyClassroomException::postNotFound);
        if(postCreatingDTO.getTitle() != null)
            updatedPost.setTitle(postCreatingDTO.getTitle());
        if(postCreatingDTO.getAttachment() != null)
            updatedPost.setAttachment(postCreatingDTO.getAttachment());
        if(postCreatingDTO.getContent() != null)
            updatedPost.setContent(postCreatingDTO.getContent());
        return PostMapper.POST_MAPPER.toDto(postRepository.save(updatedPost));
    }

    @Override
    public void deletePostById(Long postId) {
        postRepository.findById(postId).orElseThrow(CompanyClassroomException::postNotFound);
        postRepository.deleteById(postId);
    }

    @Override
    public List<PostDTO> searchPost(String keyword) {
        return PostMapper.POST_MAPPER.toDtos(postRepository.searchPost(keyword));
    }
}
