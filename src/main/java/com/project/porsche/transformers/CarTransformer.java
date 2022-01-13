package com.project.porsche.transformers;

import com.project.porsche.dto.CarDto;
import com.project.porsche.dto.PictureDto;
import com.project.porsche.entity.Car;
import com.project.porsche.entity.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CarTransformer implements Transformer<Car, CarDto> {

    @Autowired
    private PictureTransformer pictureTransformer;

    @Override
    public CarDto transform(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setModel(car.getModel());
        carDto.setPrice(car.getPrice());
        carDto.setAcceleration(car.getAcceleration());
        carDto.setBodyType(car.getBodyType());
        carDto.setDriveType(car.getDriveType());
        carDto.setCombinedFuelCons(car.getCombinedFuelCons());
        carDto.setEngineDisplacement(car.getEngineDisplacement());
        carDto.setFuelConsInTheCity(car.getFuelConsInTheCity());
        carDto.setHeight(car.getHeight());
        carDto.setInterior(car.getInterior());
        carDto.setLength(car.getLength());
        carDto.setTransmission(car.getTransmission());
        carDto.setFuelType(car.getFuelType());
        carDto.setPayload(car.getPayload());
        carDto.setPlaces(car.getPlaces());
        carDto.setPower(car.getPower());
        carDto.setWeight(car.getWeight());
        carDto.setFuelTankVolume(car.getFuelTankVolume());
        carDto.setYearOfManufacture(car.getYearOfManufacture());
        carDto.setMaxSpeed(car.getMaxSpeed());
        carDto.setFuelConsOutsideTheCity(car.getFuelConsOutsideTheCity());
        carDto.setNumberOfDoors(car.getNumberOfDoors());
        carDto.setTypeOfTransmission(car.getTypeOfTransmission());
        Set<PictureDto> pics = car.getPics().stream()
                .map(pictureTransformer::transform)
                .collect(Collectors.toSet());
        carDto.setPics(pics);
        return carDto;
    }

    @Override
    public Car transform(CarDto carDto) {
        Car car = new Car();
        car.setId(carDto.getId());
        car.setModel(carDto.getModel());
        car.setPrice(carDto.getPrice());
        car.setAcceleration(carDto.getAcceleration());
        car.setBodyType(carDto.getBodyType());
        car.setDriveType(carDto.getDriveType());
        car.setCombinedFuelCons(carDto.getCombinedFuelCons());
        car.setEngineDisplacement(carDto.getEngineDisplacement());
        car.setFuelConsInTheCity(carDto.getFuelConsInTheCity());
        car.setHeight(carDto.getHeight());
        car.setInterior(carDto.getInterior());
        car.setLength(carDto.getLength());
        car.setTransmission(carDto.getTransmission());
        car.setFuelType(carDto.getFuelType());
        car.setPayload(carDto.getPayload());
        car.setPlaces(carDto.getPlaces());
        car.setPower(carDto.getPower());
        car.setWeight(carDto.getWeight());
        car.setFuelTankVolume(carDto.getFuelTankVolume());
        car.setYearOfManufacture(carDto.getYearOfManufacture());
        car.setMaxSpeed(carDto.getMaxSpeed());
        car.setFuelConsOutsideTheCity(carDto.getFuelConsOutsideTheCity());
        car.setNumberOfDoors(carDto.getNumberOfDoors());
        car.setTypeOfTransmission(carDto.getTypeOfTransmission());
        Set<Picture> pics = carDto.getPics().stream()
                .map(pictureTransformer::transform)
                .collect(Collectors.toSet());
        car.setPics(pics);
        return car;
    }
}