package com.rentbicycle.restapi.controller;


import com.rentbicycle.restapi.helper.BikeDtoMapper;
import com.rentbicycle.restapi.model.Bike;
import com.rentbicycle.restapi.model.dto.BikeDto;
import com.rentbicycle.restapi.service.BikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BikeController {

    private final BikeService bikeService;

    @GetMapping("/bikes")
    public List<BikeDto> getBikes(Optional<Integer> page, Optional<Sort.Direction> sort){
        return BikeDtoMapper.mapToBikeDto(bikeService.
                getBikes(page.orElse(0), sort.orElse(Sort.Direction.ASC)).getContent());
    }

    @GetMapping("/bikes/{id}")
    public BikeDto getSinglePost(@PathVariable long id) {
        return BikeDtoMapper.mapToBikeDto(bikeService.getSingleBike(id));
    }

    @DeleteMapping("/bikes/{id}")
    public void deleteBike(@PathVariable long id) {
        bikeService.deleteBike(id);
    }

    @PatchMapping("bikes/{id}")
    public Bike editBike(@RequestBody Bike bike, @PathVariable long id) {
        return bikeService.editBike(bike, id);
    }

    @PostMapping("bikes")
    public Bike addBike (@RequestBody Bike bike) {
        return bikeService.addBike(bike);
    }


}
