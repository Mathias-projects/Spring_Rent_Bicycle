package com.rentbicycle.restapi.controller;

import com.rentbicycle.restapi.helper.RentDtoMapper;
import com.rentbicycle.restapi.model.Rent;
import com.rentbicycle.restapi.model.dto.RentDto;
import com.rentbicycle.restapi.service.RentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RentController {

    private final RentService rentService;

    @GetMapping("/rents")
    public List<RentDto> getRents(Optional<Integer> page, Optional<Sort.Direction> sort) {
        return RentDtoMapper.mapToRentDto(rentService.getRents(page.orElse(0), sort.orElse(Sort.Direction.ASC))
                .getContent());
    }

    @GetMapping("/rents/{id}")
    public RentDto getRent(@PathVariable long id) {
        return RentDtoMapper.mapToRentDto(rentService.getSingleRent(id));
    }

    @PostMapping("/rents")
    public Rent addRent(@RequestBody Rent rent) {
        return rentService.addRent(rent);
    }

    @DeleteMapping("/rents/{id}")
    public void deleteRent(@PathVariable long id) {
        rentService.deleteRent(id);
    }
}
