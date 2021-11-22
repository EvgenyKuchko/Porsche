package com.project.porsche.controller;

import com.project.porsche.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CarController {


    @GetMapping("/cars")
    public String showCarPage(){
        return "cars";
    }
}
