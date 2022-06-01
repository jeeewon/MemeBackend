package org.example.demo.domain.member;

import lombok.*;
import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Table/*(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Entity(name="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 유저에게 고유하게 부여되는 id.
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserEntity update(String password){
        this.password = password;
        return this;
    }
}