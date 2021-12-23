package com.project.porsche.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutCompanyController {

    @GetMapping("/about-company")
    public String showAbutCompanyPage() {
        return "about-company";
    }
}