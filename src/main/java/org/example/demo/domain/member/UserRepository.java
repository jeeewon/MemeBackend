package org.example.demo.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByEmail(String email);
    Boolean existsByEmail(String email);

    UserEntity findByEmailAndPassword(String email, String password);

    @Modifying
    @Query(value="UPDATE user SET activate='N' WHERE id=:id",nativeQuery = true)
    void ActivateNo(Integer id);

    @Query(value="SELECT * FROM user WHERE email=:email AND activate='N'",nativeQuery = true)
    UserEntity alreadyExit(String email);

}