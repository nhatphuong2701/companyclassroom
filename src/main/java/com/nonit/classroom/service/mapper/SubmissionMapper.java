package com.nonit.classroom.service.mapper;

import com.nonit.classroom.entity.Submission;
import com.nonit.classroom.service.dto.SubmissionDTO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface SubmissionMapper {

    SubmissionMapper INSTANCE = Mappers.getMapper(SubmissionMapper.class);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "assignmentId", source = "assignment.id")
    SubmissionDTO toDto(Submission submission);

    List<SubmissionDTO> toDtos(List<Submission> submissions);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "assignment.id", source = "assignmentId")
    @Mapping(target = "id", ignore = true)
    void updateSubmissionFromDTO(SubmissionDTO submissionDTO, @MappingTarget Submission submission);
}
