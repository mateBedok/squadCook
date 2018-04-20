package com.mate.bedok.squadCook.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class MainFeedPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 800)
    private String description;
    private String recipe;
    private String imgUrl;


    private String dateOfPost;

    private boolean posted;

    @ManyToOne
    private User postedBy;

    @OneToMany(mappedBy = "mainFeedPost")
    private List<Comment> comments;


    //TODO enum??
    private String status;
    private int likeCounter;

    public MainFeedPost() {
    }

    public MainFeedPost(String imgUrl, User postedBy) {
        this.imgUrl = imgUrl;
        this.postedBy = postedBy;
        this.status = "ACTIVE";
        this.likeCounter = 0;
        this.posted = false;
    }

    public MainFeedPost(String description, String recipe, String imgUrl, String dateOfPost, User postedBy) {
        this.description = description;
        this.recipe = recipe;
        this.imgUrl = imgUrl;
        this.dateOfPost = dateOfPost;
        this.postedBy = postedBy;
        this.status = "ACTIVE";
        this.likeCounter = 0;
        this.posted = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDateOfPost() {
        return dateOfPost;
    }

    public void setDateOfPost(String dateOfPost) {
        this.dateOfPost = dateOfPost;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(User postedBy) {
        this.postedBy = postedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public boolean isPosted() {
        return posted;
    }

    public void setPosted(boolean posted) {
        this.posted = posted;
    }

    public List<String> getSeparatedIngredients(String recipe) {
        List<String> recipeList = new ArrayList<>();
        String newRec = recipe.replaceAll("-", "");
        String lines[] = newRec.split("\\r?\\n");

        Collections.addAll(recipeList, lines);

        return recipeList;
    }
}
