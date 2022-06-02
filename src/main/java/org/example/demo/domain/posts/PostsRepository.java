package org.example.demo.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {
    @Query(value = "SELECT * FROM posts p WHERE activate = 'Y' ORDER BY p.id DESC", nativeQuery = true)
    Page<Posts> findAllDesc(Pageable pageable);

    @Query(value = "SELECT * FROM posts WHERE activate ='Y' AND type=:type AND category= COALESCE(:category, category)",nativeQuery = true)
    Page<Posts> findByTypeAndCategory(String type, String category, Pageable pageable);

    @Query(value = "SELECT * FROM posts WHERE activate ='Y' AND (keyw =:keyword OR keyww =:keyword OR keywww=:keyword) AND type=:type",nativeQuery = true)
    Page<Posts> findByKeywordAndType(String keyword, String type, Pageable pageable);

    @Query(value = "select * from posts where activate ='Y'",nativeQuery = true)
    Page<Posts> findAll(Pageable pageable);

    @Modifying
    @Query(value = "update posts p set p.likes = p.likes + 1 where p.id = :id", nativeQuery = true)
    Integer updateLikes(Integer id);

    @Modifying
    @Query(value = "update posts p set p.bookmark_cnt = p.bookmark_cnt + 1 where p.id = :id", nativeQuery = true)
    Integer updateBookmarkCnt(Integer id);

    @Modifying
    @Query(value = "update posts p set p.report = p.report + 1 where p.id = :id", nativeQuery = true)
    Integer updateReport(Integer id);

    @Query(value="select * from posts p where p.activate='Y' and p.user_id = :id and p.type = :type",nativeQuery = true)
    Page<Posts> findByUserAndType(Integer id,String type,Pageable pageable);

    Page<Posts> findByIdAndType(Integer id,String type,Pageable pageable);
    @Query(value="select * from posts p where p.activate='Y' and p.type=:type order by p.likes desc",nativeQuery = true)
    Page<Posts> ranking(String type,Pageable pageable);

    @Modifying
    @Query(value="UPDATE posts SET activate='N' where id=:id",nativeQuery = true)
    void ActivateNo(Integer id);

    @Modifying
    @Query(value="UPDATE posts SET activate='N' where user_id=:user_id",nativeQuery = true)
    void deleteByUser(Integer user_id);

}
