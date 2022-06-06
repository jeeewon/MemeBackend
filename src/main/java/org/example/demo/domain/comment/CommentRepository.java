package org.example.demo.domain.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    @Query(value = "SELECT * FROM comment c WHERE c.user_id=:id AND c.activate='Y' ORDER BY c.id DESC",nativeQuery = true)
    Page<Comment> findByUser(Integer id, Pageable pageable);

    @Modifying
    @Query(value="UPDATE comment SET activate='N' where post_id=:post_id",nativeQuery = true)
    void deleteByPost(Integer post_id);

    @Modifying
    @Query(value="UPDATE comment SET activate='N' where user_id=:user_id",nativeQuery = true)
    void deleteByUser(Integer user_id);
}
