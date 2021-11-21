package com.project.porsche.controller;

import com.project.porsche.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ManagerController {

    @Autowired
    private UserService userService;

    @GetMapping("/manager")
    public String showManagerPage(){
        return "manager";
    }
}
