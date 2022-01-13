package com.project.porsche.controller;

import com.project.porsche.dto.CarDto;
import com.project.porsche.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/model")
public class ModelController {

    @Autowired
    private CarService carService;

    @GetMapping("/{model}")
    public String showModelInfo(@PathVariable String model, Model mod) {
        CarDto car = carService.getCarByModel(model);
        mod.addAttribute("car", car);
        return "model";
    }
}