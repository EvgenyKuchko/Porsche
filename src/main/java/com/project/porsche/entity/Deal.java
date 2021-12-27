package com.project.porsche.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Timestamp;

@Entity
@Table(name = "deal")
@Getter
@Setter
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Country must be specified")
    private String country;
    @NotBlank(message = "City must be specified")
    private String city;
    @Pattern(regexp = "\\+[0-9]{12}", message = "Phone number must start with +, then - 12 numbers")
    private String phoneNumber;
    private String status;
    private Timestamp creatingDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}