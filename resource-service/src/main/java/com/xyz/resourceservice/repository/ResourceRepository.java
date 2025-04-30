package com.xyz.resourceservice.repository;

import com.xyz.resourceservice.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    Resource findBySlug(String slug);

    @Query(value = "SELECT * FROM resources WHERE MATCH(title, description, tags) AGAINST(:q IN NATURAL LANGUAGE MODE)", nativeQuery = true)
    List<Resource> search(@Param("q") String query);
}