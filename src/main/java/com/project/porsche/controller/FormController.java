package com.project.porsche.controller;

import com.project.porsche.entity.Car;
import com.project.porsche.entity.Form;
import com.project.porsche.entity.User;
import com.project.porsche.service.CarService;
import com.project.porsche.service.FormService;
import com.project.porsche.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/form")
public class FormController {

    @Autowired
    private FormService formService;

    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;

    @GetMapping("/{model}")
    public String showForm(@PathVariable String model, Model mod, Authentication authentication, Form form){
        form.setCar(carService.getCarByModel(model));
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        form.setUser(userService.getUserByLogin(userDetails.getUsername()));
        mod.addAttribute("form", new Form());
        return "form";
    }

    @PostMapping("/{model}")
    public String saveNewForm(Form form, Authentication authentication, @PathVariable String model){
//        Car car = carService.getCarByModel(model);
//        System.out.println("car: " + car.getPrice());
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        User user = userService.getUserByLogin(userDetails.getUsername());
//        System.out.println("User: " + user.getFirstName());
        formService.saveForm(form);
        return "redirect:/deal";
    }
}