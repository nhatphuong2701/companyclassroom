package com.nonit.classroom.rest.resource;

import com.nonit.classroom.rest.api.CommentAPI;
import com.nonit.classroom.service.CommentService;
import com.nonit.classroom.service.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class CommentResource implements CommentAPI {

    @Autowired
    private CommentService commentService;

    @Override
    public ResponseEntity<List<CommentDTO>> getAllComments() {
        return ResponseEntity.ok(commentService.getAllComments());
    }

    @Override
    public ResponseEntity<CommentDTO> createComment(CommentDTO commentDTO) {
        CommentDTO newComment = commentService.createComment(commentDTO);
        return ResponseEntity.created(URI.create("/api/comments/" + newComment.getId())).body(newComment);
    }

    @Override
    public ResponseEntity<CommentDTO> updateCommentById(Long commentId, CommentDTO commentDTO) {
        return ResponseEntity.ok().body(commentService.updateComment(commentId, commentDTO));
    }

    @Override
    public ResponseEntity<Void> deleteCommentById(Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<CommentDTO>> getCommentByPostId(Long postId) {
        return ResponseEntity.ok(commentService.getCommentByPostId(postId));
    }
}
