package com.mate.bedok.squadCook.controller;

import com.mate.bedok.squadCook.entities.MainFeedPost;
import com.mate.bedok.squadCook.entities.Squad;
import com.mate.bedok.squadCook.entities.User;
import com.mate.bedok.squadCook.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
    private SquadService squadService;

    @Autowired
    private RelationshipService relationshipService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPageView(Model model, HttpServletRequest request) {
        addModelInfoToIndexPage(model, request);
        return "mainFeed";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";

    }

    //TODO
    @RequestMapping(value = "/savePost", method = RequestMethod.POST)
    public String savePost(@RequestParam Map<String, String> data, ModelMap model, HttpServletRequest request) {

        User currentUser = userService.getCurrentUser(request);
        MainFeedPost feedPost = mainFeedPostService.getUnfinishedFeedPost(currentUser);
        //TODO empty post handling
        if (data.get("postDescription").equals("") || feedPost == null || data.get("ingredientsContent").equals("-")) {
            System.out.println("feedpost null");
            return "redirect:/";
        }

        mainFeedPostService.updateMainFeedPost(data, feedPost);
        return "redirect:/";

    }

    @RequestMapping(value = "/saveComment", method = RequestMethod.POST)
    @ResponseBody
    public String saveComment(@RequestBody Map<String, String> commentData, HttpServletRequest request) {
        commentService.save(commentData, request);
        return "success";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(@RequestBody Map<String, String> data, HttpServletRequest request) {
        //System.out.println(data.get("url"));
        User currentUser = userService.getCurrentUser(request);
        MainFeedPost mainFeedPost = new MainFeedPost(data.get("url"), currentUser);
        mainFeedPostService.saveMainFeedPost(mainFeedPost);
        return "success";
    }

    //test
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403() {
        return "403 Oopsiee";

    }

    //TODO
    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chatBox(Model model, HttpServletRequest request) {
        return "chatBox";
    }

    @RequestMapping(value = "/discover_squads", method = RequestMethod.GET)
    public String discoverSquads(Model model, HttpServletRequest request) {
        addModelInfoToDiscoverSquads(model, request);
        List<Squad> squads = squadService.getAllSquads();
        model.addAttribute("squads", squads);
        return "discoverSquads";
    }

    //TODO
    @RequestMapping(value = "/profile_page", method = RequestMethod.GET)
    public String profilePage(Model model, HttpServletRequest request) {

        return "profilePage";
    }

    @RequestMapping(value = "/requestSquadJoin", method = RequestMethod.POST)
    @ResponseBody
    public String requestSquadJoin(@RequestBody Map<String, String> requestData, HttpServletRequest request) {
        User user = userService.getCurrentUser(request);
        relationshipService.requestJoin(
                user,
                Long.valueOf(requestData.get("squadId")),
                squadService
        );
        return "success";
    }

    // model

    private void addModelInfoToDiscoverSquads(Model model, HttpServletRequest request) {
        User user = userService.getCurrentUser(request);
        String userFullName = user.getFirstName()+ " " +user.getLastName();

        model.addAttribute("userFullName", userFullName);
        model.addAttribute("profileImage", user.getProfileImage());
        model.addAttribute("activeRelationship", squadService.activeSquadFirends(relationshipService, user));
        model.addAttribute("pendingRelationship", squadService.pendingSquadFirends(relationshipService, user));

    }

    private void addModelInfoToIndexPage(Model model, HttpServletRequest request) {
        User user = userService.getCurrentUser(request);
        String userFullName = user.getFirstName()+ " " +user.getLastName();

        model.addAttribute("userFullName", userFullName);
        model.addAttribute("posts", mainFeedPostService.getAllFeedPostsOrdered());
        model.addAttribute("profileImage", user.getProfileImage());
        model.addAttribute("comments", commentService.getAllComments());
    }
}
