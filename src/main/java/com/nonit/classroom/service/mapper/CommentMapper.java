package com.nonit.classroom.service.mapper;

import com.nonit.classroom.entity.Comment;
import com.nonit.classroom.service.dto.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "userId", source = "user.id")
    CommentDTO toDto (Comment comment);

    List<CommentDTO> toDtos (List<Comment> comments);
}
