package com.nonit.classroom.service.mapper;

import com.nonit.classroom.entity.Reply;
import com.nonit.classroom.service.dto.ReplyDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReplyMapper extends EntityMapper<ReplyDTO, Reply> {

    @Override
    ReplyDTO toDto(Reply reply);
}
