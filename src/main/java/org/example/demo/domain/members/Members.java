package org.example.demo.domain.members;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Members {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column
    private Integer m_seq;

    @Column(nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String pw;

    @Column(columnDefinition = "integer default 1")
    private Integer m_status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private Role role;//권한 -> USER, ADMIN

    @Builder
    public Members(Integer m_seq, String id, String pw, Integer m_status, Role role){
        this.m_seq = m_seq;
        this.id = id;
        this.pw = pw;
        this.m_status = m_status;
        this.role = role;

    }

    //유저권한
    public String getRoleKey(){
        return this.role.getKey();
    }
    /*
    public void addUserAuthority() {
        this.role = Role.USER;
    }
    */

    /* 연관관계 매서드
    public void addPost(Post post){
        //post의 writer 설정은 post에서 함
        postList.add(post);
    }

    public void addComment(Comment comment){
        //comment의 writer 설정은 comment에서 함
        commentList.add(comment);
    }
    */

    //패스워드 암호화
    public void encodePassword(PasswordEncoder passwordEncoder){
        this.pw = passwordEncoder.encode(pw);
    }

    //비밀번호 일치여부
    public boolean matchPassword(PasswordEncoder passwordEncoder, String checkPassword){
        return passwordEncoder.matches(checkPassword, getPw());
    }

}
