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
        UserEntity userEntity = userRepository.findByEmail(email);
        String type = (postsRepository.findById(post_id)).get().getType();
        System.out.println(type);
        bookmarkRepository.bookmark(post_id,type,userEntity.getId());
    }
    @Transactional
    public void unBookmark(Integer post_id,String email){
        UserEntity userEntity = userRepository.findByEmail(email);
        bookmarkRepository.unBookmark(post_id, userEntity.getId());
    }
}
