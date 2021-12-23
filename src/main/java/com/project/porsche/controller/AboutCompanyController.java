package com.project.porsche.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about-company")
public class AboutCompanyController {

    @GetMapping()
    public String showAbutCompanyPage() {
        return "about-company";
    }
}