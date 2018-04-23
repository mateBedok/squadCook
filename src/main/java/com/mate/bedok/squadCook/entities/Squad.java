package com.mate.bedok.squadCook.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "squad_id")
    private long squadId;

    private String squadName;
    private String squadDescription;

    @ManyToMany(mappedBy = "squads")
    private Set<User> members;

    @ManyToMany(mappedBy = "followedSquads")
    private Set<User> followers;

    public Squad() {
    }

    public Squad(String squadName, String squadDescription, Set<User> members, Set<User> followers) {
        this.squadName = squadName;
        this.squadDescription = squadDescription;
        this.members = members;
        this.followers = followers;
    }

    public Squad(String squadName, String squadDescription) {
        this.squadName = squadName;
        this.squadDescription = squadDescription;
    }

    public long getSquadId() {
        return squadId;
    }

    public void setSquadId(long squadId) {
        this.squadId = squadId;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getSquadDescription() {
        return squadDescription;
    }

    public void setSquadDescription(String squadDescription) {
        this.squadDescription = squadDescription;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public Set<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<User> followers) {
        this.followers = followers;
    }

    public int getMembersCount() {
        return members.size();
    }
}
