package com.nonit.classroom.service.mapper;

import com.nonit.classroom.entity.User;
import com.nonit.classroom.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDto (User user);

    List<UserDTO> toDtos (List<User> users);
}
