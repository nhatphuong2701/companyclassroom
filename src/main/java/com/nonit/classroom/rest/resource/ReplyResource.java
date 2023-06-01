package com.nonit.classroom.rest.resource;

import com.nonit.classroom.entity.Reply;
import com.nonit.classroom.rest.api.ReplyAPI;
import com.nonit.classroom.service.ReplyService;
import com.nonit.classroom.service.dto.ReplyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class ReplyResource implements ReplyAPI {

    private final ReplyService replyService;

    @Override
    public ResponseEntity<Reply> createReply(ReplyDTO replyDTO, Long commentId, Long parentId) {
        Reply newReply = replyService.createReply(replyDTO, commentId, parentId);
        return ResponseEntity.created(URI.create("api/{commentId}/{parentId}/reply/" + newReply.getId())).body(newReply);
    }
}
