package com.mate.bedok.squadCook.repository;

import com.mate.bedok.squadCook.entities.Relationship;
import com.mate.bedok.squadCook.entities.RelationshipStatusEnum;
import com.mate.bedok.squadCook.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, Long> {
    public List<Relationship> getBySentByIdAndStatus(User user, RelationshipStatusEnum statusEnum);
}
