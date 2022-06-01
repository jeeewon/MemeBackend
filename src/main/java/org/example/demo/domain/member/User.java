package org.example.demo.domain.member;

import lombok.*;
import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table/*(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Entity(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 유저에게 고유하게 부여되는 id.
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password; // 패스워드. null이 가능한 이유는 oAuth로 페이스북이나 트위터같은 제3의 어플리케이션을 통해 로그인 할 수 있게 하기 위함이다.

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User update(String password){
        this.password = password;
        return this;
    }
}