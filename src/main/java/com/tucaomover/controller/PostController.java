package com.tucaomover.controller;


import com.tucaomover.entities.Comment;
import com.tucaomover.entities.Gossip;
import com.tucaomover.entities.User;
import com.tucaomover.service.PostUtil;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gao
 */
@RestController
@RequestMapping("/p")
public class PostController {
    PostUtil postUtil = new PostUtil();
    
    @GetMapping("/{postId}")
    public ModelAndView post(@PathVariable String postId, HttpServletRequest request ){
        Gossip post = postUtil.loadPost(postId);
        ModelAndView model = new ModelAndView("post");
        model.addObject("p", post);
        User user = (User) request.getSession().getAttribute("user");
        postUtil.viewed(user, post);
        return model;
    }
}
