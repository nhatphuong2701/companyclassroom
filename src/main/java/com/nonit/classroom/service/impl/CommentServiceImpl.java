package com.nonit.classroom.service.impl;

import com.nonit.classroom.repository.UserRepository;
import com.nonit.classroom.service.dto.creatingDTO.CommentCreatingDTO;
import com.nonit.classroom.service.mapper.CommentMapper;
import com.nonit.classroom.entity.Comment;
import com.nonit.classroom.entity.Post;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.CommentRepository;
import com.nonit.classroom.repository.PostRepository;
import com.nonit.classroom.service.CommentService;
import com.nonit.classroom.service.dto.CommentDTO;
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
        return CommentMapper.COMMENT_MAPPER.toDtos(commentRepository.findAll());
    }

    @Override
    public CommentDTO createComment(CommentCreatingDTO commentCreatingDTO) {
        Comment newComment = Comment.builder()
                .user(userRepository.findById(commentCreatingDTO.getUserId()).
                        orElseThrow(ClassroomException::userNotFound))
                .post(postRepository.findById(commentCreatingDTO.getPostId()).
                        orElseThrow(ClassroomException::postNotFound))
                .content(commentCreatingDTO.getContent())
                .attachment(commentCreatingDTO.getAttachment())
                .build();
        return CommentMapper.COMMENT_MAPPER.toDto(commentRepository.save(newComment));
    }

    @Override
    public CommentDTO updateCommentById(Long commentId, CommentCreatingDTO commentCreatingDTO) {
        Comment updateComment = commentRepository.findById(commentId).orElseThrow(ClassroomException::commentNotFound);
        if(commentCreatingDTO.getAttachment() != null)
            updateComment.setAttachment(commentCreatingDTO.getAttachment());
        if(commentCreatingDTO.getAttachment() != null)
            updateComment.setContent(commentCreatingDTO.getContent());
        return CommentMapper.COMMENT_MAPPER.toDto(commentRepository.save(updateComment));
    }

    @Override
    public void deleteCommentById(Long commentId) {
        commentRepository.findById(commentId);
        commentRepository.deleteById(commentId);
    }

    @Override
    public List<CommentDTO> findByPostId(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(ClassroomException::postNotFound);
        return CommentMapper.COMMENT_MAPPER.toDtos(commentRepository.findByPost(post));
    }
}
