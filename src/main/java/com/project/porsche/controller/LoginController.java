package com.project.porsche.controller;

import com.project.porsche.service.SecurityService;
import com.project.porsche.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @GetMapping("/login")
    public String showLoginForm(){
        return "login";
    }

}