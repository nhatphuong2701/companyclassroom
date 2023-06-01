package com.nonit.classroom.service.mapper;

import com.nonit.classroom.entity.Post;
import com.nonit.classroom.service.dto.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {

    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    @Mapping(target = "classId", source = "clazz.id")
    @Mapping(target = "userId", source = "user.id")
    PostDTO toDto(Post post);

    List<PostDTO> toDtos(List<Post> posts);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "clazz.id", source = "classId")
    @Mapping(target = "user.id", source = "userId")
    void updatePostFromDTO(PostDTO postDTO, @MappingTarget Post post);

}
