package com.rentbicycle.restapi.controller;


import com.rentbicycle.restapi.model.Bike;
import com.rentbicycle.restapi.service.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BikeController {

    private final BikeService bikeService;

    @GetMapping("/bikes")
    public List<Bike> getBikes(Optional<Integer> page, Optional<Sort.Direction> sort){
        return bikeService.getBikes(page.orElse(0), sort.orElse(Sort.Direction.ASC)).getContent();
    }

}
