package com.mate.bedok.squadCook.services;

import com.mate.bedok.squadCook.entities.Comment;
import com.mate.bedok.squadCook.entities.MainFeedPost;
import com.mate.bedok.squadCook.entities.User;
import com.mate.bedok.squadCook.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class CommentService {

    @Autowired
    CommentRepository cr;

    @Autowired
    UserService userService;

    @Autowired
    MainFeedPostService mainFeedPostService;

    public void save(Map<String, String> commentData, HttpServletRequest request) {
        String currentUserEmail = request.getUserPrincipal().getName();
        User user = userService.getUserByEmail(currentUserEmail);
        MainFeedPost mainFeedPost = mainFeedPostService.getFeedPostById(Long.parseLong(commentData.get("mainFeedPostId")));
        Comment comment = new Comment(commentData.get("commentContent"), user, mainFeedPost);
        cr.save(comment);
    }

    // needed for the init bean
    public void initSave(Comment comment) {
        cr.save(comment);
    }

    public List<Comment> getAllComments() {
        return cr.findAll();
    }
}
