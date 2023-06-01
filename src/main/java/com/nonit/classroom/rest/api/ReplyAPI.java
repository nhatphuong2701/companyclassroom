package com.nonit.classroom.rest.api;

import com.nonit.classroom.entity.Reply;
import com.nonit.classroom.service.dto.ReplyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("api/")
public interface ReplyAPI {

    @PostMapping("{commentId}/{parentId}/reply")
    ResponseEntity<Reply> createReply(@RequestBody ReplyDTO replyDTO,
                                      @PathVariable Long commentId,
                                      @PathVariable Long parentId);
}
