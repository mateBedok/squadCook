package com.mate.bedok.squadCook.services;

import com.mate.bedok.squadCook.entities.Relationship;
import com.mate.bedok.squadCook.repository.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationshipService {

    @Autowired
    RelationshipRepository rr;

    public void save(Relationship relationship) {
        rr.save(relationship);
    }
}
