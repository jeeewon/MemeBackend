package org.example.demo.domain.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    @Query(value = "select content from comment c where c.post_id = :post_id",nativeQuery = true)
    //Page<Comment> findByPostId(Integer postId, Pageable pageable);
    List<Comment> findByPost(Integer post_id);
}
