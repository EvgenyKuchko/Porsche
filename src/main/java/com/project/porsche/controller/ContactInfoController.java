package com.project.porsche.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactInfoController {

    @GetMapping("/contacts")
    public String showContactInfoPage() {
        return "contact-info";
    }
}