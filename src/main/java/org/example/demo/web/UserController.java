package org.example.demo.web;

import org.example.demo.domain.member.UserEntity;
import org.example.demo.web.dto.member.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.security.TokenProvider;
import org.example.demo.services.member.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.example.demo.web.dto.ResponseDTO;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenProvider tokenProvider;

    // Bean으로 작성해도 됨.
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDTO) {
        try {
            // 리퀘스트를 이용해 저장할 유저 만들기
            UserEntity userEntity = UserEntity.builder()
                    .email(userDTO.getEmail())
                    .password(passwordEncoder.encode(userDTO.getPassword()))
                    .build();
            // 서비스를 이용해 리파지토리에 유저 저장
            /*if(!userDTO.getPasswordConfirm().equals(userDTO.getPassword())){
                log.warn("password not equal");
                throw new RuntimeException("비밀번호가 일치하지 않습니다");
            }*/
            UserEntity registeredUserEntity = userService.create(userEntity);
            UserDto responseUserDto = UserDto.builder()
                    .email(registeredUserEntity.getEmail())
                    .id(registeredUserEntity.getId())
                    .build();
            // 유저 정보는 항상 하나이므로 그냥 리스트로 만들어야하는 ResponseDTO를 사용하지 않고 그냥 UserDTO 리턴.
            return ResponseEntity.ok(responseUserDto);
        } catch (Exception e) {
            // 예외가 나는 경우 bad 리스폰스 리턴.
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }
    /*@GetMapping("/user-email/exist")
    public ResponseEntity<Boolean> checkEmailDuplicate(@RequestParam String email){
        return ResponseEntity.ok(userService.checkEmailDuplicate(email));
    }*/
    @GetMapping("/user-email/exist")
    public ResponseEntity<Boolean> checkEmailDuplicate(@RequestParam String email){
        return ResponseEntity.ok(userService.checkEmailDuplicate(email));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody UserDto userDTO) {
        UserEntity userEntity = userService.getByCredentials(
                userDTO.getEmail(),
                userDTO.getPassword(),
                passwordEncoder);

        if(userEntity != null) {
            // 토큰 생성
            final String token = tokenProvider.create(userEntity);
            final UserDto responseUserDto = UserDto.builder()
                    .email(userEntity.getEmail())
                    .id(userEntity.getId())
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseUserDto);
        } else {
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .error("Login failed.")
                    .build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }
}