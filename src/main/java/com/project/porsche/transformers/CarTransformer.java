package com.project.porsche.transformers;

import com.project.porsche.dto.CarDto;
import com.project.porsche.dto.PictureDto;
import com.project.porsche.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CarTransformer implements TransformerDto<Car, CarDto> {

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
}