package com.project.porsche.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "car")
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

    public Car() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public int getTransmission() {
        return transmission;
    }

    public void setTransmission(int transmission) {
        this.transmission = transmission;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getPayload() {
        return payload;
    }

    public void setPayload(float payload) {
        this.payload = payload;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public float getFuelTankVolume() {
        return fuelTankVolume;
    }

    public void setFuelTankVolume(float fuelTankVolume) {
        this.fuelTankVolume = fuelTankVolume;
    }

    public float getFuelConsInTheCity() {
        return fuelConsInTheCity;
    }

    public void setFuelConsInTheCity(float fuelConsInTheCity) {
        this.fuelConsInTheCity = fuelConsInTheCity;
    }

    public float getFuelConsOutsideTheCity() {
        return fuelConsOutsideTheCity;
    }

    public void setFuelConsOutsideTheCity(float fuelConsOutsideTheCity) {
        this.fuelConsOutsideTheCity = fuelConsOutsideTheCity;
    }

    public float getCombinedFuelCons() {
        return combinedFuelCons;
    }

    public void setCombinedFuelCons(float combinedFuelCons) {
        this.combinedFuelCons = combinedFuelCons;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public int getEngineDisplacement() {
        return engineDisplacement;
    }

    public void setEngineDisplacement(int engineDisplacement) {
        this.engineDisplacement = engineDisplacement;
    }

    public String getTypeOfTransmission() {
        return typeOfTransmission;
    }

    public void setTypeOfTransmission(String typeOfTransmission) {
        this.typeOfTransmission = typeOfTransmission;
    }

    public String getDriveType() {
        return driveType;
    }

    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    public Set<Deal> getForms() {
        return deals;
    }

    public void setForms(Set<Deal> deals) {
        this.deals = deals;
    }

    public Set<Picture> getPics() {
        return pics;
    }

    public void setPics(Set<Picture> pics) {
        this.pics = pics;
    }

    public Set<Deal> getDeals() {
        return deals;
    }

    public void setDeals(Set<Deal> deals) {
        this.deals = deals;
    }

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