package org.example.demo.web.controller;

import org.example.demo.domain.member.UserEntity;
import org.example.demo.web.dto.member.ChangePwdDto;
import org.example.demo.web.dto.member.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.example.demo.security.TokenProvider;
import org.example.demo.services.member.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.example.demo.web.dto.ResponseDTO;

@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @PostMapping("/auth/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDto userDTO) {
        try {

            UserEntity userEntity = UserEntity.builder()
                    .email(userDTO.getEmail())
                    .password(passwordEncoder.encode(userDTO.getPassword()))
                    .activate("Y")
                    .build();
          
            UserEntity registeredUserEntity = userService.create(userEntity);
            UserDto responseUserDto = UserDto.builder()
                    .email(registeredUserEntity.getEmail())
                    .id(registeredUserEntity.getId())
                    .activate(registeredUserEntity.getActivate())
                    .build();

            return ResponseEntity.ok(responseUserDto);
        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity
                    .badRequest()
                    .body(responseDTO);
        }
    }

    @GetMapping("/auth/user-email/exist")
    public ResponseEntity<Boolean> checkEmailDuplicate(@RequestParam String email){
        return ResponseEntity.ok(userService.checkEmailDuplicate(email));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> authenticate(@RequestBody UserDto userDTO) {
        UserEntity userEntity = userService.getByCredentials(
                userDTO.getEmail(),
                userDTO.getPassword(),
                passwordEncoder);

        if(!userService.checkExit(userDTO.getEmail()) && userEntity != null) {
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

    @PostMapping("/mypage/change-pwd")
    public Boolean changePassword(Authentication authentication,@RequestBody ChangePwdDto changePwdDto){
        return userService.updatePwd(authentication.getName(),changePwdDto);
    }
    @PostMapping("/exit")
    public Integer deleteMember(Authentication authentication){
        return userService.delete(authentication.getName());
    }
}
