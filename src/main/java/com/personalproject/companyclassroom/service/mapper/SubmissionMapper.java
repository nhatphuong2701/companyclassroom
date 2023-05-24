package com.personalproject.companyclassroom.service.mapper;

import com.personalproject.companyclassroom.entity.Classroom;
import com.personalproject.companyclassroom.entity.Submission;
import com.personalproject.companyclassroom.service.dto.ClassroomDTO;
import com.personalproject.companyclassroom.service.dto.SubmissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubmissionMapper {
    SubmissionMapper SUBMISSION_MAPPER = Mappers.getMapper(SubmissionMapper.class);

    SubmissionDTO toDto (Submission submission);

    List<SubmissionDTO> toDtos (List<Submission> submissions);
}
