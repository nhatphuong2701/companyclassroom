package com.nonit.classroom.service.impl;

import com.nonit.classroom.repository.UserRepository;
import com.nonit.classroom.service.dto.creatingDTO.PostCreatingDTO;
import com.nonit.classroom.service.mapper.PostMapper;
import com.nonit.classroom.entity.Post;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.ClassRepository;
import com.nonit.classroom.repository.PostRepository;
import com.nonit.classroom.service.PostService;
import com.nonit.classroom.service.dto.PostDTO;
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
    private ClassRepository classRepository;

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
                        orElseThrow(ClassroomException::userNotFound))
                .clazz(classRepository.findById(postCreatingDTO.getClassroomId()).
                        orElseThrow(ClassroomException::classroomNotFound))
                .build();
        return PostMapper.POST_MAPPER.toDto(postRepository.save(post));
    }

    @Override
    public PostDTO updatePostById(Long postId, PostCreatingDTO postCreatingDTO) {
        Post updatedPost = postRepository.findById(postId).orElseThrow(ClassroomException::postNotFound);
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
        postRepository.findById(postId).orElseThrow(ClassroomException::postNotFound);
        postRepository.deleteById(postId);
    }

    @Override
    public List<PostDTO> searchPost(String keyword) {
        return PostMapper.POST_MAPPER.toDtos(postRepository.searchPost(keyword));
    }
}
