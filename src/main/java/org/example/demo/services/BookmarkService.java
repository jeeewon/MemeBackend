/*package org.example.demo.services;

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
    public void bookmark(long postId,String email){
        UserEntity userEntity = userRepository.findByEmail(email);
        bookmarkRepository.bookmark(postId, userEntity.getId());
    }
    @Transactional
    public void unBookmark(long postId,String email){
        UserEntity userEntity = userRepository.findByEmail(email);
        bookmarkRepository.unBookmark(postId, userEntity.getId());
    }
}*/
