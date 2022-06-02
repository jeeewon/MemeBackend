package org.example.demo.domain.bookmark;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark,Integer> {
    //Bookmark findBookmarkByPostsAndUserEntity(Posts posts, User user);

    @Modifying
    @Query(value = "INSERT INTO bookmark(post_id,type,user_id) VALUES(:post_id,:type,:user_id)",nativeQuery = true)
    void bookmark(Integer post_id,String type,Integer user_id);

    @Modifying
    @Query(value = "DELETE FROM bookmark WHERE post_id = :post_id AND user_id=:user_id",nativeQuery = true)
    void unBookmark(Integer post_id,Integer user_id);

    @Query(value="select * from bookmark where user_id = :id and type=:type",nativeQuery = true)
    Page<Bookmark> findByUserAndType(Integer id,String type,Pageable pageable);
}
