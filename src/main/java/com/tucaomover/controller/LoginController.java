/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.controller;

import com.tucaomover.entities.User;
import com.tucaomover.service.UserDetails;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author gao
 */
@Controller
public class LoginController {

    private final UserDetails userDetails = new UserDetails();

    
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String init(@ModelAttribute("user") User user){
        if(null==user)
            user = new User();
        return "/login";
    }
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ModelAndView login( HttpServletRequest request,@Valid @ModelAttribute("user")User user,BindingResult result){
        ModelAndView model;
        if( result.hasFieldErrors("email") || result.hasFieldErrors("password")){
            model = new ModelAndView("login",result.getModel());
            
        }
        else{

            boolean auth = userDetails.userAuth(user.getEmail(), user.getPassword());

            if(auth){
                User authed = userDetails.loadByEmail(user.getEmail());
                model = new ModelAndView("redirect: home");
                model.addObject("user",authed);
                request.getSession().setAttribute("user", authed);
                
            }
            else{
                String error = "Incorrect username or password, please try again";
                model=new ModelAndView("login");
                model.addObject("error", error);

            }
        }
        return model;
    }
    @RequestMapping(value="/logout")
    public String logout(HttpServletRequest request,@ModelAttribute("user") User user){
        user=null;
        request.getSession().invalidate();
        return "redirect:login";
    }
    
}
