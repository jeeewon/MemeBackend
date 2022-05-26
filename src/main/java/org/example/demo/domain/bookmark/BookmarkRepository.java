/*package org.example.demo.domain.bookmark;

import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.member.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository extends JpaRepository<Bookmark,Long> {
    Bookmark findBookmarkByPostsAndUser(Posts posts, UserEntity userEntity);

    @Modifying
    @Query(value = "INSERT INTO bookmark(post_id,user_id) VALUES(:postId, :userId)",nativeQuery = true)
    void bookmark(long postId,long userId);

    @Modifying
    @Query(value = "DELETE FROM bookmark WHERE post_id = :postId AND user_id=:userId",nativeQuery = true)
    void unBookmark(long postId,long userId);
}
*/