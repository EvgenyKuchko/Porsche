package com.project.porsche.controller;

import com.project.porsche.entity.Car;
import com.project.porsche.entity.Deal;
import com.project.porsche.entity.User;
import com.project.porsche.service.CarService;
import com.project.porsche.service.DealService;
import com.project.porsche.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class DealController {

    @Autowired
    private DealService dealService;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @GetMapping("/form/{model}")
    public String showForm(@PathVariable String model, Model mod,
                           Authentication authentication){
        Car car = carService.getCarByModel(model);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.getUserByLogin(userDetails.getUsername());
        LocalDateTime date = LocalDateTime.now();
        mod.addAttribute("date", date);
        mod.addAttribute("car", car);
        mod.addAttribute("user", user);
        mod.addAttribute("deal", new Deal());
        return "form";
    }

    @PostMapping("/form/{model}")
    public String saveNewDeal(Deal deal) {
        dealService.saveDeal(deal);
        return "redirect:/deal";
    }

    @GetMapping("/deal")
    public String showDealPage(){
        return "deal";
    }
}