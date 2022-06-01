package org.example.demo.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FIleRepository extends JpaRepository<File,Integer> {
}
