package com.rentbicycle.restapi.controller;


import com.rentbicycle.restapi.helper.RentStationDtoMapper;
import com.rentbicycle.restapi.model.RentStation;
import com.rentbicycle.restapi.model.dto.RentStationDto;
import com.rentbicycle.restapi.service.RentStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RentStationController {

    private final RentStationService rentStationService;

    @GetMapping("/rentStations")
    public List<RentStationDto> getRentStations(Optional<Integer> page, Optional<Sort.Direction> sort) {
        return RentStationDtoMapper.mapToRentStationDto(rentStationService.getRentStations(page.orElse(0),
                sort.orElse(Sort.Direction.ASC)).getContent());
    }

    @GetMapping("/rentStations/{id}")
    public RentStationDto getRentStation(@PathVariable long id) {
        return RentStationDtoMapper.mapToRentStationDto(rentStationService.getSingleRentStation(id));
    }

    @GetMapping("/rentStations/bikes")
    public List<RentStation> getRentStationsWithBikes(Optional<Integer> page, Optional<Sort.Direction> sort){
        return rentStationService.getRentStations(page.orElse(0), sort.orElse(Sort.Direction.ASC)).getContent();
    }

    @GetMapping("/rentStations/bikes/{id}")
    public RentStation getRentStationWithBikes(@PathVariable long id) {
        return rentStationService.getSingleRentStation(id);
    }

    @PostMapping("/rentStations")
    public RentStation addRentStation(@RequestBody RentStation rentStation) { return rentStationService.addRentStation(rentStation);}

    @DeleteMapping("/rentStations/{id}")
    public void deleteRentStation(@PathVariable long id) {
        rentStationService.deleteRentStation(id);
    }

}
