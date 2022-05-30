package org.example.demo.services.bookmark;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.bookmark.BookmarkRepository;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.member.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BookmarkService {
    private final UserRepository userRepository;
    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public void bookmark(Integer post_id,String email){
        UserEntity userEntity = userRepository.findByEmail(email);
        bookmarkRepository.bookmark(post_id, userEntity.getId());
    }
    @Transactional
    public void unBookmark(Integer post_id,String email){
        UserEntity userEntity = userRepository.findByEmail(email);
        bookmarkRepository.unBookmark(post_id, userEntity.getId());
    }
}
