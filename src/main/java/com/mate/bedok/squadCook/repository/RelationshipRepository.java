package com.mate.bedok.squadCook.repository;

import com.mate.bedok.squadCook.entities.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
}
