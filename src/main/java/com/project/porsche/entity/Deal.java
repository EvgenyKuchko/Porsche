package com.project.porsche.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deal")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String status;
    private Date creatingDate;
    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "car_id")
    private Car car;

    public Deal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }

    @Override
    public String toString() {
        return "Deal{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", creatingDate=" + creatingDate +
                ", user=" + user +
                ", car=" + car +
                '}';
    }
}