package com.personalproject.companyclassroom.service.dto;

import com.personalproject.companyclassroom.entity.Classroom;
import com.personalproject.companyclassroom.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipateDTO {
    private Long id;
    private User user;
    private Classroom classroom;
}
