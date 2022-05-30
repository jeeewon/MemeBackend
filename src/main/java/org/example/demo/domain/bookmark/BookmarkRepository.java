package org.example.demo.domain.bookmark;

import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.member.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookmarkRepository extends JpaRepository<Bookmark,Integer> {
    Bookmark findBookmarkByPostsAndUserEntity(Posts posts, UserEntity userEntity);

    @Modifying
    @Query(value = "INSERT INTO bookmark(post_id,user_id) VALUES(:post_id, :user_id)",nativeQuery = true)
    void bookmark(Integer post_id,Integer user_id);

    @Modifying
    @Query(value = "DELETE FROM bookmark WHERE post_id = :post_id AND user_id=:user_id",nativeQuery = true)
    void unBookmark(Integer post_id,Integer user_id);

}
