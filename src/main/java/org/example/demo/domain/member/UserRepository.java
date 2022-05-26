package org.example.demo.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);
    Boolean existsByEmail(String email);

    UserEntity findByEmailAndPassword(String email, String password);

}