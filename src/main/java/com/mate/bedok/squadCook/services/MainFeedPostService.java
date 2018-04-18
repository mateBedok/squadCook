package com.mate.bedok.squadCook.services;

import com.mate.bedok.squadCook.entities.MainFeedPost;
import com.mate.bedok.squadCook.entities.User;
import com.mate.bedok.squadCook.repository.MainFeedPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainFeedPostService {

    @Autowired
    MainFeedPostRepository mfr;

    public void saveMainFeedPost(MainFeedPost mainFeedPost) {
        mfr.save(mainFeedPost);
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
