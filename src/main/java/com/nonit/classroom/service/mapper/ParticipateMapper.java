package com.nonit.classroom.service.mapper;

import com.nonit.classroom.entity.Participate;
import com.nonit.classroom.service.dto.ParticipateDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ParticipateMapper {

    ParticipateMapper INSTANCE = Mappers.getMapper(ParticipateMapper.class);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "classId", source = "clazz.id")
    ParticipateDTO toDto(Participate participate);

    List<ParticipateDTO> toDtos(List<Participate> participates);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "clazz.id", source = "classId")
    void updateParticipationFromDTO(ParticipateDTO participateDTO, @MappingTarget Participate participate);
}
