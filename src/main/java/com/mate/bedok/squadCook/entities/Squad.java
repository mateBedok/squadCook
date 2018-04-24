package com.mate.bedok.squadCook.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "squad_id")
    private long squadId;

    private String squadName;
    private String squadDescription;
    private String squadImage;

    //private Set<User> admins;

    @ManyToMany(mappedBy = "squads")
    private Set<User> admins;



    @OneToMany(mappedBy = "sentToId")
    List<Relationship> sentToRelationships;

    public Squad() {
    }

    //TODO set creating user as admin..admin roles
    public Squad(String squadName, String squadDescription, Set<User> admins) {
        this.squadName = squadName;
        this.squadDescription = squadDescription;
        this.admins = admins;
    }

    public Squad(String squadName, String squadDescription, String squadImage) {
        this.squadName = squadName;
        this.squadDescription = squadDescription;
        this.squadImage = squadImage;
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

    public Set<User> getAdmins() {
        return admins;
    }

    public void setAdmins(Set<User> admins) {
        this.admins = admins;
    }

    public int getMembersCount() {
        return admins.size();
    }

    public String getSquadImage() {
        return squadImage;
    }

    public void setSquadImage(String squadImage) {
        this.squadImage = squadImage;
    }
}
