package com.mate.bedok.squadCook.services;

import com.mate.bedok.squadCook.entities.MainFeedPost;
import com.mate.bedok.squadCook.entities.User;
import com.mate.bedok.squadCook.repository.MainFeedPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class MainFeedPostService {

    @Autowired
    MainFeedPostRepository mfr;

    public void saveMainFeedPost(MainFeedPost mainFeedPost) {
        mfr.save(mainFeedPost);
    }

    public void updateMainFeedPost(Map<String, String> data, MainFeedPost feedPost) {
        String description = data.get("postDescription");
        String recipe = data.get("ingredientsContent");

        feedPost.setDescription(description);
        feedPost.setRecipe(recipe);
        feedPost.setDateOfPost("today");
        feedPost.setPosted(true);
        saveMainFeedPost(feedPost);

    }

    public List<MainFeedPost> getAllFeedPosts() {
        return mfr.findAll();
    }

    public List<MainFeedPost> getAllFeedPostsOrdered() {
        return mfr.findAllByIdNotNullOrderByIdDesc();
    }

    public MainFeedPost getFeedPostById(long id) {
        return mfr.getById(id);
    }

    public MainFeedPost getUnfinishedFeedPost(User user) {
        return mfr.getByPostedByAndPosted(user, false);
    }

}
