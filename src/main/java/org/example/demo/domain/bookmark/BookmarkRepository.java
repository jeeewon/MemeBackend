package org.example.demo.domain.bookmark;

import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.posts.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark,Integer> {
    @Query(value = "SELECT COUNT(id) FROM bookmark WHERE post_id=:post_id and user_id=:user_id",nativeQuery = true)
    Long findBookmarkByPostsAndUserEntity(Integer post_id, Integer user_id);

    @Modifying
    @Query(value = "INSERT INTO bookmark(post_id,type,user_id) VALUES(:post_id,:type,:user_id)",nativeQuery = true)
    void bookmark(Integer post_id,String type,Integer user_id);

    @Modifying
    @Query(value = "DELETE FROM bookmark WHERE post_id = :post_id AND user_id=:user_id",nativeQuery = true)
    void unBookmark(Integer post_id,Integer user_id);

    @Query(value = "SELECT COUNT(id) from bookmark where post_id=:post_id and user_id =:user_id",nativeQuery = true)
    Long bookmarkYN(Integer post_id,Integer user_id);
    @Query(value="select * from bookmark where user_id = :id and type=:type and activate='Y'",nativeQuery = true)
    Page<Bookmark> findByUserAndType(Integer id,String type,Pageable pageable);

    @Modifying
    @Query(value="UPDATE bookmark SET activate='N' where post_id=:post_id",nativeQuery = true)
    void deleteByPost(Integer post_id);

    @Modifying
    @Query(value="UPDATE bookmark SET activate='N' where user_id=:user_id",nativeQuery = true)
    void deleteByUser(Integer user_id);

}
