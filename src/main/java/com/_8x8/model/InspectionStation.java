package com._8x8.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Beniamin on 8/30/2016.
 */
@Entity
@Table(name = "inspectionStation")
public class InspectionStation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inspectionStation_id")
    private Long id;

    @Column(name = "location")
    private String location;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "inspectionStations")
    private Set<Car> cars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
