package com.nonit.classroom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name = "replies",
            joinColumns = @JoinColumn(name = "parent_reply_id"),
            inverseJoinColumns = @JoinColumn(name = "child_reply_id")
    )
    private Set<Reply> childReplies = new HashSet<>();

    @ManyToMany(mappedBy = "childReplies")
    private Set<Reply> parentReplies = new HashSet<>();

    public void addParentReply(Reply parentReply) {
        parentReplies.add(parentReply);
        parentReply.getChildReplies().add(this);
    }
}
