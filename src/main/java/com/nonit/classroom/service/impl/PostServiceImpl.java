package com.nonit.classroom.service.impl;

import com.nonit.classroom.entity.Post;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.ClassRepository;
import com.nonit.classroom.repository.PostRepository;
import com.nonit.classroom.repository.UserRepository;
import com.nonit.classroom.service.PostService;
import com.nonit.classroom.service.dto.PostDTO;
import com.nonit.classroom.service.mapper.PostMapper;
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
        return PostMapper.INSTANCE.toDtos(postRepository.findAll());
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) {
        Post post = Post.builder()
                .title(postDTO.getTitle())
                .content(postDTO.getContent())
                .attachment(postDTO.getAttachment())
                .user(userRepository.findById(postDTO.getUserId()).
                        orElseThrow(ClassroomException::userNotFound))
                .clazz(classRepository.findById(postDTO.getClassId()).
                        orElseThrow(ClassroomException::classroomNotFound))
                .build();
        return PostMapper.INSTANCE.toDto(postRepository.save(post));
    }

    @Override
    public PostDTO updatePost(Long postId, PostDTO postDTO) {
        Post updatedPost = postRepository.findById(postId).orElseThrow(ClassroomException::postNotFound);
        PostMapper.INSTANCE.updatePostFromDTO(postDTO, updatedPost);
        return PostMapper.INSTANCE.toDto(postRepository.save(updatedPost));
    }

    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    @Override
    public List<PostDTO> searchPost(String keyword) {
        return PostMapper.INSTANCE.toDtos(postRepository.searchPost(keyword));
    }
}
