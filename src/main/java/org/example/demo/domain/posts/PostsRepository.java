package org.example.demo.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {
    @Query(value = "SELECT * FROM posts p ORDER BY p.id DESC", nativeQuery = true)
    Page<Posts> findAllDesc(Pageable pageable);

    Page<Posts> findByTypeOrCategory(String type, String category, Pageable pageable);

    Page<Posts> findByKeywAndType(String keyw, String type, Pageable pageable);

    Page<Posts> findAll(Pageable pageable);

    @Modifying
    @Query(value = "update posts p set p.likes = p.likes + 1 where p.id = :id", nativeQuery = true)
    Integer updateLikes(Integer id);

    @Modifying
    @Query(value = "update posts p set p.bookmark_cnt = p.bookmark_cnt + 1 where p.id = :id", nativeQuery = true)
    Integer updateBookmarkCnt(Integer id);

    @Query(value="select * from posts p where p.user_id = :id and p.type = :type",nativeQuery = true)
    Page<Posts> findByUserAndType(Integer id,String type,Pageable pageable);

    Page<Posts> findByIdAndType(Integer id,String type,Pageable pageable);
    @Query(value="select * from posts p where p.type=:type order by p.likes desc",nativeQuery = true)
    Page<Posts> ranking(String type,Pageable pageable);
}
