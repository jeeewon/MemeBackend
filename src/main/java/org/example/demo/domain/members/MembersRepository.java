package org.example.demo.domain.members;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MembersRepository extends JpaRepository<Members,Integer> {
    Optional<Members> findByM_seq(Integer m_seq);
}
