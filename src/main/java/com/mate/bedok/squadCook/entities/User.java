package com.mate.bedok.squadCook.entities;

import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    private String firstName;


    private String lastName;

    private String userName;


    private String email;


    private String birthDate;


    private String password;


    private String registrationDate;

    private String profileImage;

    private boolean enabled;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum userRole;

    @OneToMany(mappedBy = "sentById")
    List<Relationship> sentByRelationships;

    @OneToMany(mappedBy = "postedBy")
    List<MainFeedPost> mainFeedPosts = new ArrayList<>();

    @OneToMany(mappedBy = "commentedBy")
    List<Comment> comments = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "User_Squad",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "squad_id") }
    )
    Set<Squad> squads;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "User_FollowedSquad",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "squad_id") }
    )
    Set<Squad> followedSquads;

    public User() {
    }


    public User(String firstName, String lastName, String userName, String email, String birthDate, String password, String registrationDate, String profileImage) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.birthDate = birthDate;
        //this.password = BCrypt.hashpw(password,BCrypt.gensalt());
        this.password = password;
        this.registrationDate = registrationDate;
        this.profileImage = profileImage;
        this.enabled = true;
        this.userRole = UserRoleEnum.ROLE_USER;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
    }

    public Set<Squad> getSquads() {
        return squads;
    }

    public void setSquads(Set<Squad> squads) {
        this.squads = squads;
    }

    public void addSquad(Squad squad) {
        squads.add(squad);
    }
}
