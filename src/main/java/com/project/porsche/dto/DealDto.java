package com.project.porsche.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DealDto implements Dto {
    private long id;
    private String country;
    private String city;
    private String phoneNumber;
    private String status;
    private Timestamp creatingDate;
    private String firstName;
    private String lastName;
    private String model;
    private String price;
}