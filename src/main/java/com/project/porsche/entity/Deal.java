package com.project.porsche.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "deal")
@Getter
@Setter
public class Deal implements EntityObj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String country;
    private String city;
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