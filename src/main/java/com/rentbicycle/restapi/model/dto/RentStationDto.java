package com.rentbicycle.restapi.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RentStationDto {
    private long id;
    private String street;
    private String city;
}
