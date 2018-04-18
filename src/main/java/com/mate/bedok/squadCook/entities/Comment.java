package com.mate.bedok.squadCook.entities;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String commentContent;
    private String dateCommented;

    @ManyToOne
    private User commentedBy;

    @ManyToOne
    private MainFeedPost mainFeedPost;

    private int likeCounter;

    public Comment() {
    }

    public Comment(String commentContent, User commentedBy, MainFeedPost mainFeedPost) {
        this.commentContent = commentContent;
        this.commentedBy = commentedBy;
        this.mainFeedPost = mainFeedPost;
        this.dateCommented = "2018-04-11";
        this.likeCounter = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getDateCommented() {
        return dateCommented;
    }

    public void setDateCommented(String dateCommented) {
        this.dateCommented = dateCommented;
    }

    public User getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(User commentedBy) {
        this.commentedBy = commentedBy;
    }

    public MainFeedPost getMainFeedPost() {
        return mainFeedPost;
    }

    public void setMainFeedPost(MainFeedPost mainFeedPost) {
        this.mainFeedPost = mainFeedPost;
    }

    public int getLikeCounter() {
        return likeCounter;
    }

    public void setLikeCounter(int likeCounter) {
        this.likeCounter = likeCounter;
    }
}
