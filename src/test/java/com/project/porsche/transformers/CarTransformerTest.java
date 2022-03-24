package com.project.porsche.transformers;

import com.project.porsche.dto.CarDto;
import com.project.porsche.entity.Car;
import com.project.porsche.entity.Picture;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTransformerTest {

    private static final CarTransformer carTransformer = new CarTransformer();

    @Test
    public void shouldTransformCarToCarDto() {
        Car car = new Car();
        car.setModel("918");
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
        picOne.setFilePath("img/img1.jpeg");
        Picture picTwo = new Picture();
        picTwo.setFilePath("img/img2.jpeg");
        Set<Picture> pictures = new HashSet<>();
        pictures.add(picOne);
        pictures.add(picTwo);
        car.setPics(pictures);

        CarDto carDto = carTransformer.transform(car);

        assertThat(car.getPrice())
                .isEqualTo(carDto.getPrice());
        assertThat(car.getLength())
                .isEqualTo(carDto.getLength());
        assertThat(car.getFuelType())
                .isEqualTo(carDto.getFuelType());
    }
}