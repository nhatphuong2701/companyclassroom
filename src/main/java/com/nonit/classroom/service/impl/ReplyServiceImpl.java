package com.nonit.classroom.service.impl;

import com.nonit.classroom.entity.Reply;
import com.nonit.classroom.exception.ClassroomException;
import com.nonit.classroom.repository.CommentRepository;
import com.nonit.classroom.repository.ReplyRepository;
import com.nonit.classroom.repository.UserRepository;
import com.nonit.classroom.service.ReplyService;
import com.nonit.classroom.service.dto.ReplyDTO;
import com.nonit.classroom.service.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final ReplyMapper replyMapper;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    @Override
    public Reply createReply(ReplyDTO replyDTO, Long commentId, Long parentId) {
        Reply parentReply = replyRepository.findById(parentId).orElse(null);
        Reply newReply = Reply.builder()
                .content(replyDTO.getContent())
                .user(userRepository.findById(replyDTO.getUserId())
                        .orElseThrow(ClassroomException::userNotFound))
                .comment((commentRepository.findById(commentId)
                        .orElseThrow(ClassroomException::commentNotFound)))
                .build();
        if (parentReply == null) {
            newReply.addParentReply(newReply);
        } else {
            parentReply.getChildReplies().add(newReply);
        }
        return replyRepository.save(newReply);
    }
}
