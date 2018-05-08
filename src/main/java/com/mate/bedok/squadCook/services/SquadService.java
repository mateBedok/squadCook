package com.mate.bedok.squadCook.services;

import com.mate.bedok.squadCook.entities.Relationship;
import com.mate.bedok.squadCook.entities.Squad;
import com.mate.bedok.squadCook.entities.User;
import com.mate.bedok.squadCook.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public Squad findSquadById(Long id) {
        return sr.findOne(id);
    }

    public List<Squad> activeSquadFirends(RelationshipService relationshipService, User user) {

        List<Squad> activeSquads = new ArrayList<>();

        for (Relationship rel : relationshipService.getActiveRelationshipsByUserId(user)) {
            activeSquads.add(rel.getSentToId());
        }
        return activeSquads;
    }

    public List<Squad> pendingSquadFirends(RelationshipService relationshipService, User user) {

        List<Squad> pendingSquads = new ArrayList<>();

        for (Relationship rel : relationshipService.getPendingRelationshipByUerId(user)) {
            pendingSquads.add(rel.getSentToId());
        }
        return pendingSquads;
    }


}
