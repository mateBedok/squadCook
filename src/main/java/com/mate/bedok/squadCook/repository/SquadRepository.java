package com.mate.bedok.squadCook.repository;

import com.mate.bedok.squadCook.entities.Squad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SquadRepository extends JpaRepository<Squad, Long> {
}
