package com.project.porsche.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class CarDto implements Dto {
    private long id;
    private String model;
    private String price;
    private String interior;
    private int transmission;
    private String fuelType;
    private int power;
    private float acceleration;
    private int maxSpeed;
    private float weight;
    private float height;
    private float length;
    private float payload;
    private int places;
    private float fuelTankVolume;
    private float fuelConsInTheCity;
    private float fuelConsOutsideTheCity;
    private float combinedFuelCons;
    private String bodyType;
    private int numberOfDoors;
    private int yearOfManufacture;
    private int engineDisplacement;
    private String typeOfTransmission;
    private String driveType;
    private Set<PictureDto> pics;
}