package com.personalproject.companyclassroom.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRoleAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User users;

    @CreationTimestamp
    @Column(name = "assigned_date")
    private LocalDateTime assignedDate;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private LocalDateTime updatedDate;
}
