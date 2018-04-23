package com.mate.bedok.squadCook.entities;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = {@UniqueConstraint(columnNames = {
                "sent_by_id_user_id", "sent_to_id_user_id"
        })}
)
public class Relationship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User sentById;

    @ManyToOne
    private User sentToId;

    @Enumerated(EnumType.STRING)
    private RelationshipStatusEnum status;

    public Relationship() {
    }

    public Relationship(User sentById, User sentToId) {
        this.sentById = sentById;
        this.sentToId = sentToId;
        this.status = RelationshipStatusEnum.PENDING;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getSentById() {
        return sentById;
    }

    public void setSentById(User sentById) {
        this.sentById = sentById;
    }

    public User getSentToId() {
        return sentToId;
    }

    public void setSentToId(User sentToId) {
        this.sentToId = sentToId;
    }

    public RelationshipStatusEnum getStatus() {
        return status;
    }

    public void setStatus(RelationshipStatusEnum status) {
        this.status = status;
    }
}
