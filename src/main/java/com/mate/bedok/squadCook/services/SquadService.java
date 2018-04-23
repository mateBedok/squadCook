package com.mate.bedok.squadCook.services;

import com.mate.bedok.squadCook.entities.Squad;
import com.mate.bedok.squadCook.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SquadService {

    @Autowired
    SquadRepository sr;

    public void saveSquad(Squad squad) {
        sr.save(squad);
    }

    public List<Squad> getAllSquads() {
        return sr.findAll();
    }

    public void requestJoin() {
        //TODO requestJoin
    }
}
