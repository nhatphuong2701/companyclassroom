package com.personalproject.companyclassroom.service.impl;

import com.personalproject.companyclassroom.entity.Comment;
import com.personalproject.companyclassroom.entity.Post;
import com.personalproject.companyclassroom.exception.CompanyClassroomException;
import com.personalproject.companyclassroom.repository.CommentRepository;
import com.personalproject.companyclassroom.repository.PostRepository;
import com.personalproject.companyclassroom.security.repository.UserRepository;
import com.personalproject.companyclassroom.service.CommentService;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.creatingDTO.CommentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.CommentDTO;
import com.personalproject.companyclassroom.service.mapper.ClassroomMapper;
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
                .attachment(commentCreatingDTO.getAttachment())
                .build();
        return CommentMapper.COMMENT_MAPPER.toDto(commentRepository.save(newComment));
    }

    @Override
    public CommentDTO updateCommentById(Long commentId, CommentCreatingDTO commentCreatingDTO) {
        Comment updateComment = commentRepository.findById(commentId).orElseThrow(CompanyClassroomException::commentNotFound);
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
        Post post = postRepository.findById(postId).orElseThrow(CompanyClassroomException::postNotFound);
        return CommentMapper.COMMENT_MAPPER.toDtos(commentRepository.findByPost(post));
    }
}
