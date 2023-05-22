package com.personalproject.companyclassroom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classrooms")
public class Classroom {
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(nullable = false)
    private Long academicYear;

    @Column(nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
