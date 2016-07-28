/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tucaomover.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author gao
 */
@Controller
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public String error(Model model, Exception e){
        model.addAttribute("error", e);
        return "error";
    }
}
