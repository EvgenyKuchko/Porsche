package com.project.porsche.service;

import com.project.porsche.entity.Car;
import com.project.porsche.entity.Picture;
import com.project.porsche.repository.CarRepository;
import com.project.porsche.transformers.CarTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {

    @InjectMocks
    private CarService carService;
    @Mock
    private CarRepository carRepository;
    @Mock
    private CarTransformer carTransformer;

    @Test
    void shouldReturnCarByModel() {
        String model = "911";
        Car car = new Car();
        car.setModel(model);
        car.setPrice("1000");
        car.setAcceleration(1.3f);
        car.setBodyType("sedan");
        car.setCombinedFuelCons(1.3f);
        car.setDriveType("combine");
        car.setEngineDisplacement(4);
        car.setFuelConsInTheCity(10.5f);
        car.setFuelConsOutsideTheCity(8.5f);
        car.setFuelTankVolume(50.1f);
        car.setFuelType("diesel");
        car.setHeight(1.66f);
        car.setInterior("skin");
        car.setLength(4.07f);
        car.setMaxSpeed(289);
        car.setNumberOfDoors(3);
        car.setPayload(45.5f);
        car.setPlaces(2);
        car.setPower(3000);
        car.setTransmission(6);
        car.setTypeOfTransmission("handle");
        car.setWeight(2888.5f);
        car.setYearOfManufacture(2018);
        Picture picOne = new Picture();
        picOne.setFilePath("/static/img/models/970/970-1.jpeg");
        Picture picTwo = new Picture();
        picTwo.setFilePath("/static/img/models/970/970-2.jpeg");
        Set<Picture> pictures = new HashSet<>();
        pictures.add(picOne);
        pictures.add(picTwo);
        car.setPics(pictures);

        when(carRepository.findByModel(model)).thenReturn(car);

        assertThat(carService.getCarByModel(model)).isEqualTo(carTransformer.transform(car));
    }
}