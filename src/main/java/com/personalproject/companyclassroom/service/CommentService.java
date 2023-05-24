package com.personalproject.companyclassroom.service;

import com.personalproject.companyclassroom.service.dto.creatingDTO.CommentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    List<CommentDTO> getAllComments();

    CommentDTO createComment(CommentCreatingDTO commentCreatingDTO);

    CommentDTO updateCommentById(Long commentId, CommentCreatingDTO commentCreatingDTO);

    void deleteCommentById(Long commentId);
}
