/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author gao
 */

@Controller
public class HomepageController {
    
    @RequestMapping(value="/home")
    public String homepage(Model model){
        return "home";
    }
    @RequestMapping(value="/")
    public String defaultPage(){
        return "redirect:home";
    }
}
