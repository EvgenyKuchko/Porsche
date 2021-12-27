package com.project.porsche.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private Set<Picture> pics;

    @OneToMany(mappedBy = "car", cascade = CascadeType.REFRESH)
    private Set<Deal> deals;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price='" + price + '\'' +
                ", interior='" + interior + '\'' +
                ", transmission=" + transmission +
                ", fuelType='" + fuelType + '\'' +
                ", power=" + power +
                ", acceleration=" + acceleration +
                ", maxSpeed=" + maxSpeed +
                ", weight=" + weight +
                ", height=" + height +
                ", length=" + length +
                ", payload=" + payload +
                ", places=" + places +
                ", fuelTankVolume=" + fuelTankVolume +
                ", fuelConsInTheCity=" + fuelConsInTheCity +
                ", fuelConsOutsideTheCity=" + fuelConsOutsideTheCity +
                ", combinedFuelCons=" + combinedFuelCons +
                ", bodyType='" + bodyType + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", yearOfManufacture=" + yearOfManufacture +
                ", engineDisplacement=" + engineDisplacement +
                ", typeOfTransmission='" + typeOfTransmission + '\'' +
                ", driveType='" + driveType + '\'' +
                ", forms=" + deals +
                '}';
    }
}