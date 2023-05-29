package com.personalproject.companyclassroom.repository;

import com.personalproject.companyclassroom.entity.Comment;
import com.personalproject.companyclassroom.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findByPost(Post post);
}
