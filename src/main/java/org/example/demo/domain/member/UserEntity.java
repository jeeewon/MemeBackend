package org.example.demo.domain.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class UserEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id; // 유저에게 고유하게 부여되는 id.


    @Column(nullable = false)
    private String email; // 유저의 email, 아이디와 같은 기능을 한다.

    @Column(nullable = false)
    private String password; // 패스워드. null이 가능한 이유는 oAuth로 페이스북이나 트위터같은 제3의 어플리케이션을 통해 로그인 할 수 있게 하기 위함이다.

    /*
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;


    public String getRoleKey() {
        return this.role.getKey();
    }
    */
    public UserEntity update(String password){
        this.password = password;
        return this;
    }
}