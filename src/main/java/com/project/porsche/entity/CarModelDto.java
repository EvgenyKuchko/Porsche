package com.project.porsche.entity;

import com.project.porsche.dto.Dto;
import lombok.Data;

@Data
public class CarModelDto implements Dto {
    private String model;
    private String price;
}