package com.project.porsche.controller;

import com.project.porsche.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/cars")
    public String showCarPage(){
        return "cars";
    }
}
