package com.project.porsche.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DealController {

    @GetMapping("/deal")
    public String showDealPage(){
        return "deal";
    }
}