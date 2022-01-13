package com.project.porsche.transformers;

import com.project.porsche.entity.Car;
import com.project.porsche.entity.CarModelDto;
import org.springframework.stereotype.Component;

@Component
public class CarModelTransformer implements Transformer<Car, CarModelDto> {
    @Override
    public CarModelDto transform(Car car) {
        CarModelDto carModelDto = new CarModelDto();
        carModelDto.setModel(car.getModel());
        carModelDto.setPrice(car.getPrice());
        return carModelDto;
    }

    @Override
    public Car transform(CarModelDto carModelDto) {
        Car car = new Car();
        car.setModel(carModelDto.getModel());
        car.setPrice(carModelDto.getPrice());
        return car;
    }
}