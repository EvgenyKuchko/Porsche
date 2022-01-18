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
        return CarDto.builder()
                .id(car.getId())
                .model(car.getModel())
                .price(car.getPrice())
                .acceleration(car.getAcceleration())
                .bodyType(car.getBodyType())
                .driveType(car.getDriveType())
                .combinedFuelCons(car.getCombinedFuelCons())
                .engineDisplacement(car.getEngineDisplacement())
                .fuelConsInTheCity(car.getFuelConsInTheCity())
                .height(car.getHeight())
                .interior(car.getInterior())
                .length(car.getLength())
                .transmission(car.getTransmission())
                .fuelType(car.getFuelType())
                .payload(car.getPayload())
                .places(car.getPlaces())
                .power(car.getPower())
                .weight(car.getWeight())
                .fuelTankVolume(car.getFuelTankVolume())
                .yearOfManufacture(car.getYearOfManufacture())
                .maxSpeed(car.getMaxSpeed())
                .fuelConsOutsideTheCity(car.getFuelConsOutsideTheCity())
                .numberOfDoors(car.getNumberOfDoors())
                .typeOfTransmission(car.getTypeOfTransmission())
                .pics(getPics(car))
                .build();
    }

    private Set<PictureDto> getPics(Car car) {
        return car.getPics().stream()
                .map(pictureTransformer::transform)
                .collect(Collectors.toSet());
    }
}