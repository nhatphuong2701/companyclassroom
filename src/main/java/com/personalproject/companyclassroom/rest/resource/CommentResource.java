package com.personalproject.companyclassroom.rest.resource;

import com.personalproject.companyclassroom.rest.api.CommentAPI;
import com.personalproject.companyclassroom.service.CommentService;
import com.personalproject.companyclassroom.service.dto.creatingDTO.CommentCreatingDTO;
import com.personalproject.companyclassroom.service.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentResource implements CommentAPI {

    private final CommentService commentService;


    @Override
    public ResponseEntity<List<CommentDTO>> getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @Override
    public ResponseEntity<CommentDTO> createComment(CommentCreatingDTO commentCreatingDTO) {
        CommentDTO newComment = commentService.createComment(commentCreatingDTO);
        return ResponseEntity.created(URI.create("/api/comments/" + newComment.getId())).body(newComment);
    }

    @Override
    public ResponseEntity<CommentDTO> updateCommentById(Long commentId, CommentCreatingDTO commentCreatingDTO) {
        return ResponseEntity.ok().body(commentService.updateCommentById(commentId,commentCreatingDTO)) ;
    }

    @Override
    public void deleteCommentById(Long commentId) {
        commentService.deleteCommentById(commentId);
        ResponseEntity.noContent().build();
    }
}