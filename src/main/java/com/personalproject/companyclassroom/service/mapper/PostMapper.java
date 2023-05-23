package com.personalproject.companyclassroom.service.mapper;

import com.personalproject.companyclassroom.entity.Course;
import com.personalproject.companyclassroom.entity.Post;
import com.personalproject.companyclassroom.service.dto.CourseDTO;
import com.personalproject.companyclassroom.service.dto.PostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PostMapper {
    PostMapper POST_MAPPER = Mappers.getMapper(PostMapper.class);


    PostDTO toDto(Post post);

    List<PostDTO> toDtos(List<Post> posts);

}
