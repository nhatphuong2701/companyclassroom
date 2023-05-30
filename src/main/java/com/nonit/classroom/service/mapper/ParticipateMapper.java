package com.nonit.classroom.service.mapper;

import com.nonit.classroom.entity.Participate;
import com.nonit.classroom.service.dto.ParticipateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ParticipateMapper {
    ParticipateMapper PARTICIPATE_MAPPER = Mappers.getMapper(ParticipateMapper.class);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "classroomId", source = "classroom.id")

    ParticipateDTO toDto (Participate participate);

    List<ParticipateDTO> toDtos (List<Participate> participates);
}
