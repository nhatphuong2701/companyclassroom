package com.nonit.classroom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "posts")
public class Post {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime postTime;

    @Column(nullable = false)
    private String content;

    private String attachment;
    private String title;

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private Clazz clazz;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
