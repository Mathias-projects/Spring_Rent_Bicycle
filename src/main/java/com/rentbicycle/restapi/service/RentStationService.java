package com.rentbicycle.restapi.service;

import com.rentbicycle.restapi.model.RentStation;
import com.rentbicycle.restapi.repository.RentStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentStationService {

    private static final int PAGE_SIZE = 5;
    private final RentStationRepository rentStationRepository;

    public Page<RentStation> getRentStations(int page, Sort.Direction sort) {
       return rentStationRepository.findAll(PageRequest.of(page, PAGE_SIZE, Sort.by(sort,"id")));
    }

    public RentStation getSingleRentStation(long id) {
        return rentStationRepository.findById(id).get();
    }

    public RentStation addRentStation(RentStation rentStation) { return rentStationRepository.save(rentStation);}

    public void deleteRentStation(long id) {
        rentStationRepository.deleteById(id);
    }
}
