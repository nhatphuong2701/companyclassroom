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
                        orElseThrow(CompanyClassroomException::userNotFound))
                .post(postRepository.findById(commentCreatingDTO.getPostId()).
                        orElseThrow(CompanyClassroomException::postNotFound))
                .content(commentCreatingDTO.getContent())
                .attachments(commentCreatingDTO.getAttachments())
                .build();
        return CommentMapper.COMMENT_MAPPER.toDto(commentRepository.save(newComment));
    }

    @Override
    public CommentDTO updateCommentById(Long commentId, CommentCreatingDTO commentCreatingDTO) {
        Comment updateComment = commentRepository.findById(commentId).orElseThrow(CompanyClassroomException::commentNotFound);
        if(commentCreatingDTO.getAttachments() != null)
            updateComment.setAttachments(commentCreatingDTO.getAttachments());
        if(commentCreatingDTO.getAttachments() != null)
            updateComment.setContent(commentCreatingDTO.getContent());
        return CommentMapper.COMMENT_MAPPER.toDto(commentRepository.save(updateComment));
    }

    @Override
    public void deleteCommentById(Long commentId) {
        commentRepository.findById(commentId);
        commentRepository.deleteById(commentId);
    }
}
