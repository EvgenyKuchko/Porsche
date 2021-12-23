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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;

@Controller
@RequestMapping("/deal")
public class DealController {

    @Autowired
    private DealService dealService;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @GetMapping("/{model}")
    public String showForm(@PathVariable String model, Model mod,
                           Authentication authentication) {
        Car car = carService.getCarByModel(model);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userService.getUserByLogin(userDetails.getUsername());
        Timestamp date = new Timestamp(System.currentTimeMillis());
        mod.addAttribute("date", date);
        mod.addAttribute("car", car);
        mod.addAttribute("user", user);
        mod.addAttribute("deal", new Deal());
        return "form";
    }

    @PostMapping("/{model}")
    public String saveNewDeal(@Valid Deal deal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        dealService.saveDeal(deal);
        return "redirect:/deal/success";
    }

    @GetMapping("/success")
    public String showDealPage() {
        return "deal";
    }
}