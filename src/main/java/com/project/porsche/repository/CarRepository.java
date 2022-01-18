package com.project.porsche.repository;

import com.project.porsche.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByModel(String model);
}