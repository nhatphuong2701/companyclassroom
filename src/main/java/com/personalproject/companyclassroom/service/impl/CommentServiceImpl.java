package com.personalproject.companyclassroom.service.impl;

import com.personalproject.companyclassroom.entity.Comment;
import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.repository.CommentRepository;
import com.personalproject.companyclassroom.repository.PostRepository;
import com.personalproject.companyclassroom.security.repository.UserRepository;
import com.personalproject.companyclassroom.service.CommentService;
import com.personalproject.companyclassroom.service.dto.creatingDTO.CommentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.CommentDTO;
import com.personalproject.companyclassroom.service.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Override
    public List<CommentDTO> getAllComments() {
        return CommentMapper.COMMENT_MAPPER.toDtos(commentRepository.findAll());
    }

    @Override
    public CommentDTO createComment(CommentCreatingDTO commentCreatingDTO) {
        Comment newComment = Comment.builder()
                .user(userRepository.findById(commentCreatingDTO.getUserId()).
                        orElseThrow(CompanyClassroomException::userNotFound))
                .post(postRepository.findById(commentCreatingDTO.getPostId()).
                        orElseThrow(CompanyClassroomException::postNotFound))
                .content(commentCreatingDTO.getContent())
                .attachment(commentCreatingDTO.getAttachment())
                .build();
        return CommentMapper.COMMENT_MAPPER.toDto(commentRepository.save(newComment));
    }

    @Override
    public CommentDTO updateCommentById(Long commentId, CommentCreatingDTO commentCreatingDTO) {
        Comment updateComment = new Comment();
        updateComment.setAttachment(commentCreatingDTO.getAttachment());
        updateComment.setContent(commentCreatingDTO.getContent());
        return CommentMapper.COMMENT_MAPPER.toDto(commentRepository.save(updateComment));
    }

    @Override
    public void deleteCommentById(Long commentId) {
        commentRepository.findById(commentId);
        commentRepository.deleteById(commentId);
    }
}
