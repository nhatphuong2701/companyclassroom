package com.personalproject.companyclassroom.entity;

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
@Table(name = "classrooms")
@NamedQuery(name = "Classroom.findActiveClassesAndNumberOfStudents",
        query = "SELECT new com.personalproject.companyclassroom.service.dto.customDTO.CustomClassroomDTO" +
                "(c, COUNT(r.user)) " +
                "FROM UserRoleAssignment r, Participate p, Classroom c " +
                "WHERE r.role LIKE ?1 and r.user.id = p.user.id and c.id = p.classroom.id and c.endDate > ?2 " +
        "GROUP BY c.id ")
public class Classroom {
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
