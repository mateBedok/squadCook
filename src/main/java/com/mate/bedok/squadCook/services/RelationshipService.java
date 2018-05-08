package com.mate.bedok.squadCook.services;

import com.mate.bedok.squadCook.entities.Relationship;
import com.mate.bedok.squadCook.entities.RelationshipStatusEnum;
import com.mate.bedok.squadCook.entities.User;
import com.mate.bedok.squadCook.repository.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipService {

    @Autowired
    RelationshipRepository rr;

    public void save(Relationship relationship) {
        rr.save(relationship);
    }

    public void requestJoin(User user, Long squadId, SquadService squadService) {
        Relationship relationship = new Relationship(user, squadService.findSquadById(squadId));
        save(relationship);
    }

    List<Relationship> getActiveRelationshipsByUserId(User user) {
        return rr.getBySentByIdAndStatus(user, RelationshipStatusEnum.ACCEPTED);
    }

    List<Relationship> getPendingRelationshipByUerId(User user) {
        return rr.getBySentByIdAndStatus(user, RelationshipStatusEnum.PENDING);
    }
}
