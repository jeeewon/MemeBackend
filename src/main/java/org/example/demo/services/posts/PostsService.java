package org.example.demo.services.posts;

import org.example.demo.domain.bookmark.BookmarkRepository;
import org.example.demo.domain.comment.CommentRepository;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.member.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import org.example.demo.domain.posts.Posts;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.web.dto.posts.PostsListResponseDto;
import org.example.demo.web.dto.posts.PostsResponseDto;
import org.example.demo.web.dto.posts.PostsSaveRequestDto;
import org.springframework.stereotype.Service;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;


@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final BookmarkRepository bookmarkRepository;

    @Transactional
    public Integer save(String email,PostsSaveRequestDto requestDto) {
        UserEntity userEntity = userRepository.findByEmail(email);
        requestDto.setUserEntity(userEntity);
        return (postsRepository.save(requestDto.toEntity())).getId();
    }
    @Transactional
    public Integer saveImage(String email,String imageUrl,PostsSaveRequestDto requestDto) {
        UserEntity userEntity = userRepository.findByEmail(email);
        requestDto.setUserEntity(userEntity);
        requestDto.setImage(imageUrl);
        return (postsRepository.save(requestDto.toEntity())).getId();
    }

    @Transactional
    public PostsResponseDto findById(Integer post_id){
        Posts entity = postsRepository.findById(post_id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+post_id));
        return new PostsResponseDto(entity);
    }
    @Transactional
    public void updateLikes(Integer id){
        postsRepository.updateLikes(id);
    }
    @Transactional
    public void updateBookmarkCnt(Integer id){
        postsRepository.updateBookmarkCnt(id);
    }
    @Transactional
    public void updateReport(Integer id){
        postsRepository.updateReport(id);
    }

    @Transactional(readOnly=true)
    public Page<PostsListResponseDto> findAllDesc(Pageable pagerequest) {
        return postsRepository.findAllDesc(pagerequest).map(
                posts -> new PostsListResponseDto(
                        posts.getId(),
                        posts.getTitle(),
                        posts.getImage()
                ));
    }

    @Transactional(readOnly=true)
    public Page<PostsListResponseDto> categoryList(String type, String category,Pageable pagerequest) {
        System.out.print("category:"+category);
        return postsRepository.findTypeAndCategory(type,category,pagerequest).map(
                posts -> new PostsListResponseDto(
                        posts.getId(),
                        posts.getTitle(),
                        posts.getImage()
                ));
    }

    @Transactional(readOnly=true)
    public Page<PostsListResponseDto> search(String keyw,String type, Pageable pagerequest) {
        return postsRepository.findByKeywordAndType(keyw,type,pagerequest).map(
                posts -> new PostsListResponseDto(
                        posts.getId(),
                        posts.getTitle(),
                        posts.getImage()
                ));
    }

    @Transactional
    public Integer delete(Integer id){
        postsRepository.ActivateNo(id);
        commentRepository.deleteByPost(id);
        bookmarkRepository.deleteByPost(id);
        return id;
    }
}
