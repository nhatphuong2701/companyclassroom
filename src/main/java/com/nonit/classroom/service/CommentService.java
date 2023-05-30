package com.nonit.classroom.service;

import com.nonit.classroom.service.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> getAllComments();

    CommentDTO createComment(CommentDTO commentDTO);

    CommentDTO updateComment(Long commentId, CommentDTO commentDTO);

    void deleteComment(Long commentId);

    List<CommentDTO> getCommentByPostId(Long postId);
}
