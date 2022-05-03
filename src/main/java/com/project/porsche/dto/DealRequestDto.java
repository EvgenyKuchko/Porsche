package com.project.porsche.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class DealRequestDto implements Dto {
    @NotBlank(message = "Country must be specified")
    private String country;
    @NotBlank(message = "City must be specified")
    private String city;
    @Pattern(regexp = "\\+[0-9]{12}", message = "Phone number must start with +, then - 12 numbers")
    private String phoneNumber;
}