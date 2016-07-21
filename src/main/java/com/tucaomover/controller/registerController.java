/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.controller;

import com.tucaomover.entities.User;
import com.tucaomover.service.UserDetails;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author gao
 */
@Controller
@RequestMapping(value = "/signup")
public class registerController {
   private UserDetails userDetails = new UserDetails();
   
   @RequestMapping( method = RequestMethod.GET)
   public String init(@ModelAttribute("user") User user){
      
       return "signup";
   }
   
   @RequestMapping( method = RequestMethod.POST)
   public ModelAndView register(HttpServletRequest request, @Valid @ModelAttribute("user") User user, BindingResult result ){
       ModelAndView model;
       
       if(result.hasErrors()){
           model = new ModelAndView("signup", result.getModel());
       }
       else{
           boolean isAdded = userDetails.addUser(user);
           if(isAdded){
               model = new ModelAndView("home");
               model.addObject("user", user);
               request.getSession().setAttribute("user", user);
               
           }
           else{
               result.rejectValue("email", "error.user", "An account aready exsits for this email");
               model = new ModelAndView("signup", result.getModel());
           }
       }
       return model;
   }
           
    
}
