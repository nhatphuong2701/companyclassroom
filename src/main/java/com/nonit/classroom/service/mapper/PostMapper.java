package com.nonit.classroom.service.mapper;

import com.nonit.classroom.entity.Comment;
import com.nonit.classroom.entity.Post;
import com.nonit.classroom.service.dto.PostDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "classId", source = "clazz.id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "commentIds", source = "comments", qualifiedByName = "extractCommentIds")
    PostDTO toDto(Post post);

    List<PostDTO> toDtos(List<Post> posts);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "clazz.id", source = "classId")
    @Mapping(target = "user.id", source = "userId")
    void updatePostFromDTO(PostDTO postDTO, @MappingTarget Post post);

    @Named("extractCommentIds")
    static List<Long> extractCommentIds(List<Comment> comments) {
        return comments.stream()
                .map(Comment::getId)
                .collect(Collectors.toList());
    }

}
