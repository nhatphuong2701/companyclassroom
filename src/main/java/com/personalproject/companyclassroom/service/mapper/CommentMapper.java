package com.personalproject.companyclassroom.service.mapper;

import com.personalproject.companyclassroom.entity.Comment;
import com.personalproject.companyclassroom.service.dto.CommentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface CommentMapper {

    CommentMapper COMMENT_MAPPER = Mappers.getMapper(CommentMapper.class);

    CommentDTO toDto (Comment comment);

    List<CommentDTO> toDtos (List<Comment> comments);
}
