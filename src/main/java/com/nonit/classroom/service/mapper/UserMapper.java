package com.nonit.classroom.service.mapper;

import com.nonit.classroom.entity.User;
import com.nonit.classroom.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    UserDTO toDto(User user);

    List<UserDTO> toDtos(List<User> users);

    @Mapping(target = "id", ignore = true)
    void updateUserForAdminFromDTO(UserDTO userDTO, @MappingTarget User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userRoleAssignment", ignore = true)
    void updateUserForUserFromDTO(UserDTO userDTO, @MappingTarget User user);
}
