package com.rentbicycle.restapi.service;

import com.rentbicycle.restapi.model.Bike;
import com.rentbicycle.restapi.repository.BikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BikeService {

    private static final int PAGE_SIZE = 10;
    private final BikeRepository bikeRepository;

    public Page<Bike> getBikes(int page, Sort.Direction sort) {
        return bikeRepository.findAll(PageRequest.of(page, PAGE_SIZE,
                Sort.by(sort, "id"))
        );
    }

    public Bike getSingleBike(long id) {
        return bikeRepository.findById(id).orElse(null);
    }

    public void deleteBike(long id) {
        bikeRepository.deleteById(id);
    }

    public Bike editBike(Bike bike, long id) {
        Bike editedBike = bikeRepository.findById(id).orElseThrow();
        editedBike.editBike(bike);
        return bikeRepository.save(editedBike);
    }

    public Bike addBike(Bike bike) {
        return bikeRepository.save(bike);
    }
}
