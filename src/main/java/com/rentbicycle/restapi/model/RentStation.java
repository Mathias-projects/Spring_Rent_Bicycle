package com.rentbicycle.restapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class RentStation {
    @Id
    private long id;
    private String street;
    private String city;
    @OneToMany
    @JoinColumn(name = "rentStationId", updatable = false, insertable = false)
    private List<Bike> bikes;
}
