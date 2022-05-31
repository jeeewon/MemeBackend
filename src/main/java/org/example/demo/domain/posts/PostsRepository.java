package org.example.demo.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {
    @Query(value = "SELECT * " +
            "FROM posts p " +
            "ORDER BY p.id DESC",nativeQuery = true)
    Page<Posts> findAllDesc(Pageable pageable);
    Page<Posts> findByTypeOrCategory(String type, String category,Pageable pageable);
    Page<Posts> findBykeywAndType(String keyw,String type,Pageable pageable);
    Page<Posts> findAll(Pageable pageable);

    @Modifying
    @Query(value = "update posts p set p.likes = p.likes + 1 where p.id = :id",nativeQuery = true)
    Integer updateLikes(Integer id);

    @Modifying
    @Query(value = "update posts p set p.bookmarkCnt = p.bookmarkCnt + 1 where p.id = :id",nativeQuery = true)
    Integer updateBookmarkCnt(Integer id);
/*
    @Modifying
    @Query("update Posts p set p.likes = p.likes + 1 where p.id = :id")
    //@Query("update Posts p set p.bookmarkCnt = p.bookmarkCnt + 1")
    Integer updateBookmarkCnt(Long id);
*/
    //@Query("SELECT p FROM Posts p WHERE p.keyw=keyword OR p.keyww=keyword OR p.keywww=keyword")
    //List<Posts> findKeyword(String keyword);
}
