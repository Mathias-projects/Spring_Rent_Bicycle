package com.rentbicycle.restapi.helper;

import com.rentbicycle.restapi.model.RentStation;
import com.rentbicycle.restapi.model.dto.RentStationDto;

import java.util.List;
import java.util.stream.Collectors;

public class RentStationDtoMapper {

    private RentStationDtoMapper(){}

    public static List<RentStationDto> mapToRentStationDto(List<RentStation> rentStations) {
        return rentStations.stream()
                .map(rentStation -> mapToRentStationDto(rentStation))
                .collect(Collectors.toList());
    }

    public static RentStationDto mapToRentStationDto(RentStation rentStation) {
        return RentStationDto.builder()
                .id(rentStation.getId())
                .city(rentStation.getCity())
                .street(rentStation.getStreet())
                .build();
    }

}
