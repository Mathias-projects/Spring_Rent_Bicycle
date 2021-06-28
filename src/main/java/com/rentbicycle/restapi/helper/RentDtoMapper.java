package com.rentbicycle.restapi.helper;

import com.rentbicycle.restapi.model.Rent;
import com.rentbicycle.restapi.model.dto.RentDto;

import java.util.List;
import java.util.stream.Collectors;

public class RentDtoMapper {

    private RentDtoMapper(){}

    public static List<RentDto> mapToRentDto(List<Rent> rents) {
        return rents.stream()
                .map(rent -> mapToRentDto(rent))
                .collect(Collectors.toList());
    }

    public static RentDto mapToRentDto(Rent rent) {
        return RentDto.builder()
                .id(rent.getId())
                .rentedDate(rent.getRentedDate())
                .userId(rent.getUserId())
                .bike(BikeDtoMapper.mapToBikeDto(rent.getBike()))
                .rentStationId(rent.getRentStationId())
                .build();
    }
}
