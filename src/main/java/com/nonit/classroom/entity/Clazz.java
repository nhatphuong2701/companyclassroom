package com.nonit.classroom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "classes")
@NamedQuery(name = "Clazz.findActiveClassesAndNumberOfStudents",
        query = "SELECT new com.nonit.classroom.service.dto.CustomClassDTO(c, COUNT(r.user)) " +
                "FROM UserRoleAssignment r, Participate p, Clazz c " +
                "WHERE r.user.id = p.user.id AND c.id = p.clazz.id " +
                "AND r.role = 'ROLE_STUDENT' and c.endDate > ?2 " +
                "GROUP BY c.id")
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(nullable = false)
    private Long academicYear;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
