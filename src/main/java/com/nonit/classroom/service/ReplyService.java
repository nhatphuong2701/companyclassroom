package com.nonit.classroom.service;

import com.nonit.classroom.entity.Reply;
import com.nonit.classroom.service.dto.ReplyDTO;

public interface ReplyService {

    public Reply createReply(ReplyDTO replyDTO, Long commentId, Long parentId);
}
