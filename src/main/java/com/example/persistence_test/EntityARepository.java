package com.example.persistence_test;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface EntityARepository extends JpaRepository<EntityA,Long> {

    Optional<EntityA> findByTextA(String textA);

    @EntityGraph(attributePaths = {"entityB"})
    List<EntityA> findAllByTextAIn(Collection<String> textAS);

    @Query("""
        select a
        from EntityA a
        Join fetch a.entityB
        """)
    List<EntityA> findAll();
}
