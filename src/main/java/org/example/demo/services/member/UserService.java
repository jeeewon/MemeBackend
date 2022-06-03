package org.example.demo.services.member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.domain.bookmark.BookmarkRepository;
import org.example.demo.domain.comment.CommentRepository;
import org.example.demo.domain.member.UserEntity;
import org.example.demo.domain.member.UserRepository;
import org.example.demo.domain.posts.PostsRepository;
import org.example.demo.web.dto.member.ChangePwdDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Slf4j
@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final BookmarkRepository bookmarkRepository;
    private final PostsRepository postsRepository;

    public UserEntity create(final UserEntity userEntity) {
        if(userEntity == null || userEntity.getEmail() == null ) {
            throw new RuntimeException("Invalid arguments");
        }

        final String email = userEntity.getEmail();
        if(userRepository.existsByEmail(email)) {
            log.warn("Email already exists {}", email);
            throw new RuntimeException("Email already exists");
        }

        return userRepository.save(userEntity);
    }

    public boolean checkEmailDuplicate(String email){
        return userRepository.existsByEmail(email);
    }

    public UserEntity getByCredentials(final String email, final String password, final PasswordEncoder encoder) {
        final UserEntity originalUserEntity = userRepository.findByEmail(email);

        // matches 메서드를 이용해 패스워드가 같은지 확인
        if(originalUserEntity != null && encoder.matches(password, originalUserEntity.getPassword())) {
            return originalUserEntity;
        }
        return null;
    }
    public Boolean checkExit(String email){
        if(userRepository.alreadyExit(email) != null){
            return true;
        }
        else return false;
    }

    @Transactional
    public Boolean updatePwd(String email,ChangePwdDto changePwdDto){
        UserEntity userEntity  = userRepository.findByEmail(email);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(passwordEncoder.matches(changePwdDto.getOldPassword(), userEntity.getPassword())){
            userRepository.updatePwd(email, passwordEncoder.encode(changePwdDto.getNewPassword()));
            return true;

        }
        else {
            throw new RuntimeException("Password is incorrect");
        }
    }

    @Transactional
    public Integer delete(String email){
        Integer id = userRepository.findByEmail(email).getId();
        userRepository.ActivateNo(id);
        postsRepository.deleteByUser(id);
        commentRepository.deleteByUser(id);
        bookmarkRepository.deleteByUser(id);
        return id;
    }
}