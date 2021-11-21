package com.project.porsche.service;

import com.project.porsche.entity.Car;
import com.project.porsche.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Transactional
    public Car getCarByModel(String model){
        return carRepository.findByModel(model);
    }
}