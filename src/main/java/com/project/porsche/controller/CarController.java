package com.project.porsche.controller;

import com.project.porsche.dto.CarDto;
import com.project.porsche.dto.PictureDto;
import com.project.porsche.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping()
    public String showCarPage(Model model) {
        List<CarDto> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "cars";
    }
}