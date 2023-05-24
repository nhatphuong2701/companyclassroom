package com.personalproject.companyclassroom.service.mapper;

import com.personalproject.companyclassroom.entity.Assignment;
import com.personalproject.companyclassroom.entity.Submission;
import com.personalproject.companyclassroom.service.dto.AssignmentDTO;
import com.personalproject.companyclassroom.service.dto.SubmissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssignmentMapper {
    AssignmentMapper ASSIGNMENT_MAPPER = Mappers.getMapper(AssignmentMapper.class);

    AssignmentDTO toDto (Assignment assignment);

    List<AssignmentDTO> toDtos (List<Assignment> assignments);
}
