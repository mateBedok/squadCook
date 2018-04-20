package com.mate.bedok.squadCook.controller;

import com.mate.bedok.squadCook.Utils.JSONUtil;
import com.mate.bedok.squadCook.entities.Comment;
import com.mate.bedok.squadCook.entities.MainFeedPost;
import com.mate.bedok.squadCook.entities.User;
import com.mate.bedok.squadCook.services.CommentService;
import com.mate.bedok.squadCook.services.MainFeedPostService;
import com.mate.bedok.squadCook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class MainFeedController {

    @Autowired
    private UserService userService;

    @Autowired
    private MainFeedPostService mainFeedPostService;

    @Autowired
    private CommentService commentService;

    @Autowired
    JSONUtil jsonUtil;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPageView(Model model, HttpServletRequest request) {
        String email = request.getUserPrincipal().getName();
        User user = userService.getUserByEmail(email);
        String userFullName = user.getFirstName()+ " " +user.getLastName();

        model.addAttribute("userName", user.getUserName());
        model.addAttribute("userFullName", userFullName);
        model.addAttribute("posts", mainFeedPostService.getAllFeedPostsOrdered());
        model.addAttribute("profileImage", user.getProfileImage());
        model.addAttribute("comments", commentService.getAllComments());
        /*if (currentUser != null) {
            model.addAttribute("userName", currentUser.getUserName());
            model.addAttribute("profileImage", currentUser.getProfileImage());
            model.addAttribute("posts", mainFeedPostService.getAllFeedPosts());
            return "mainFeed";
        }*/
        return "mainFeed";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";

    }

    //TODO ajax..
    @RequestMapping(value = "/savePost", method = RequestMethod.POST)
    public String savePost(@RequestParam Map<String, String> data, ModelMap model, HttpServletRequest request) {

        User currentUser = userService.getUserByEmail(request.getUserPrincipal().getName());
        String description = data.get("postDescription");
        String recipe = data.get("ingredientsContent");

        MainFeedPost feedPost = mainFeedPostService.getUnfinishedFeedPost(currentUser);
        //TODO empty post handling
        if (description.equals("") || feedPost == null || recipe.equals("-")) {
            System.out.println("feedpost null");
            return "redirect:/";
        }

        feedPost.setDescription(description);
        feedPost.setRecipe(recipe);
        feedPost.setDateOfPost("today");
        feedPost.setPosted(true);
        mainFeedPostService.saveMainFeedPost(feedPost);
        return "redirect:/";

    }

    @RequestMapping(value = "/saveComment", method = RequestMethod.POST)
    @ResponseBody
    public String saveComment(@RequestBody Map<String, String> commentData, HttpServletRequest request) {
        commentService.save(commentData, request);
        System.out.println(commentData.get("commentContent"));
        return "success";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestBody Map<String, String> data, HttpServletRequest request) {
        System.out.println(data.get("url"));
        User currentUser = userService.getUserByEmail(request.getUserPrincipal().getName());
        MainFeedPost mainFeedPost = new MainFeedPost(data.get("url"), currentUser);
        mainFeedPostService.saveMainFeedPost(mainFeedPost);
        return "success";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403() {
        return "403";

    }
}
