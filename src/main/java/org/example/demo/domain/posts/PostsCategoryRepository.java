/*package org.example.demo.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostsCategoryRepository extends JpaRepository<PostsCategory,Long> {
    Optional<PostsCategory> findByName (String name);
    Optional<PostsCategory> findByBranchAndName (String branch, String name);

    Boolean existsByBranchAndName(String branch, String name);
}*/
