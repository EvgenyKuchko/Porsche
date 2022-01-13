package com.project.porsche.dto;

import lombok.Data;

@Data
public class DealRequestDto implements Dto {
    private String country;
    private String city;
    private String phoneNumber;
}