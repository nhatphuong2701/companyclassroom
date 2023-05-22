package com.personalproject.companyclassroom.security.service.mapper;

import com.personalproject.companyclassroom.security.entity.User;
import com.personalproject.companyclassroom.security.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper USER_MAPPER = Mappers.getMapper(UserMapper.class);

    UserDTO toDto (User user);

    List<UserDTO> toDtos (List<User> users);
}
