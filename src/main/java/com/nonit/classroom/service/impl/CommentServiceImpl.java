package com.nonit.classroom.service.impl;

import com.nonit.classroom.entity.Comment;
import com.nonit.classroom.entity.Post;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.CommentRepository;
import com.nonit.classroom.repository.PostRepository;
import com.nonit.classroom.repository.UserRepository;
import com.nonit.classroom.service.CommentService;
import com.nonit.classroom.service.dto.CommentDTO;
import com.nonit.classroom.service.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<CommentDTO> getAllComments() {
        return CommentMapper.INSTANCE.toDtos(commentRepository.findAll());
    }

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment newComment = Comment.builder()
                .user(userRepository.findById(commentDTO.getUserId()).
                        orElseThrow(ClassroomException::userNotFound))
                .post(postRepository.findById(commentDTO.getPostId()).
                        orElseThrow(ClassroomException::postNotFound))
                .content(commentDTO.getContent())
                .attachment(commentDTO.getAttachment())
                .build();

        return CommentMapper.INSTANCE.toDto(commentRepository.save(newComment));
    }

    @Override
    public CommentDTO updateComment(Long commentId, CommentDTO commentDTO) {
        Comment updateComment = commentRepository.findById(commentId)
                .orElseThrow(ClassroomException::commentNotFound);
        return CommentMapper.INSTANCE.toDto(commentRepository.save(updateComment));
    }

    @Override
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDTO> getCommentByPostId(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(ClassroomException::postNotFound);
        return CommentMapper.INSTANCE.toDtos(commentRepository.findByPost(post));
    }
}
