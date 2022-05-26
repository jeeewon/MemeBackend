
package org.example.demo.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    Page<Posts> findAllDesc(Pageable pageable);
    Page<Posts> findByTypeOrCategory(String type, String category,Pageable pageable);
    Page<Posts> findBykeywContaining(String keyw,Pageable pageable);
    Page<Posts> findAll(Pageable pageable);

    @Modifying
    @Query("update Posts p set p.likes = p.likes + 1 where p.id = :id")
    //@Query("update Posts p set p.likes = p.likes + 1")
    Integer updateLikes(Long id);
/*
    @Modifying
    @Query("update Posts p set p.likes = p.likes + 1 where p.id = :id")
    //@Query("update Posts p set p.bookmarkCnt = p.bookmarkCnt + 1")
    Integer updateBookmarkCnt(Long id);
*/
    //@Query("SELECT p FROM Posts p WHERE p.keyw=keyword OR p.keyww=keyword OR p.keywww=keyword")
    //List<Posts> findKeyword(String keyword);
}
