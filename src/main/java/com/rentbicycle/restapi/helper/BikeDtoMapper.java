package com.rentbicycle.restapi.helper;

import com.rentbicycle.restapi.model.Bike;
import com.rentbicycle.restapi.model.Rent;
import com.rentbicycle.restapi.model.dto.BikeDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BikeDtoMapper {

    private BikeDtoMapper(){}

    public static List<BikeDto> mapToBikeDto(List<Bike> bikes) {
        return bikes.stream()
                .map(bike -> mapToBikeDto(bike))
                .collect(Collectors.toList());
    }

    public static BikeDto mapToBikeDto(Bike bike) {
        Rent rent = bike.getRent();
        Long rentId = rent == null ? null : rent.getId();
        return BikeDto.builder()
                .id(bike.getId())
                .color(bike.getColor())
                .model(bike.getModel())
                .pin(bike.getPin())
                .rentId(rentId)
                .rentStationId(bike.getRentStationId())
                .build();
    }

}
