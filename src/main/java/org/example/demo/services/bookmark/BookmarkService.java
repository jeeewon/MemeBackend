package org.example.demo.services.bookmark;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.bookmark.BookmarkRepository;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.member.UserRepository;
import org.example.demo.domain.posts.PostsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BookmarkService {
    private final UserRepository userRepository;
    private final PostsRepository postsRepository;
    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public void bookmark(Integer post_id,String email){
        Integer user_id = userRepository.findByEmail(email).getId();
        String type = (postsRepository.findById(post_id)).get().getType();
        if(bookmarkRepository.findBookmarkByPostsAndUserEntity(post_id,user_id)!=0){
            bookmarkRepository.unBookmark(post_id,user_id);
        }
        else bookmarkRepository.bookmark(post_id,type,user_id);
    }
    @Transactional
    public void unBookmark(Integer post_id,String email){
        UserEntity userEntity = userRepository.findByEmail(email);
        bookmarkRepository.unBookmark(post_id, userEntity.getId());
    }
}
