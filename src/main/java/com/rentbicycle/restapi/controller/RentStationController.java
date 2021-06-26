package com.rentbicycle.restapi.controller;


import com.rentbicycle.restapi.model.RentStation;
import com.rentbicycle.restapi.service.RentStationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RentStationController {

    private RentStationService rentStationService;

    @GetMapping("/rentStations")
    public List<RentStation> getRentStations(){
        return rentStationService.getRentStations();
    }

}
