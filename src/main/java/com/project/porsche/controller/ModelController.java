package com.project.porsche.controller;

import com.project.porsche.entity.Car;
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

    // сделать поиск полность по модели (911 Turbo)
    @GetMapping("/{model}")
    public String showModelInfo(@PathVariable String model, Model mod){
        Car car = carService.getCarByModel(model);
        mod.addAttribute("car", car);
        return "model";
    }
}