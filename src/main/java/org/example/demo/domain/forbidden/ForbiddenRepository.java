package org.example.demo.domain.forbidden;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ForbiddenRepository extends JpaRepository<Forbidden,Integer> {
    boolean existsByWord(String word);
}
