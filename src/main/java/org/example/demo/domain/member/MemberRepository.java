package org.example.demo.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<org.example.demo.domain.member.MemberEntity, Long> {
    Optional<org.example.demo.domain.member.MemberEntity> findById(String userId);
}