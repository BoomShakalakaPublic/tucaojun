/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.controller;

import com.tucaomover.entities.User;
import com.tucaomover.service.PostRanking;
import com.tucaomover.entities.RankRecord;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author gao
 */

@Controller
public class HomepageController {
    
    @RequestMapping(value="/home")
    public ModelAndView homepage(HttpServletRequest request ){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ModelAndView model = new ModelAndView("home");
        model.addObject("user", user);
        PostRanking pr = new PostRanking();
        List<RankRecord> rr = pr.rank(user);
        model.addObject("post", rr);
        
        return model;
    }
    @RequestMapping(value="/")
    public String defaultPage(){
        return "redirect:home";
    }
}
