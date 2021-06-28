package com.rentbicycle.restapi.model.dto;

import com.rentbicycle.restapi.model.Rent;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.OneToOne;

@Builder
@Getter
public class BikeDto {
    private long id;
    private Long rentStationId;
    private Long rentId;
    private String model;
    private String color;
    private long pin;
}
