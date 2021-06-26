package com.rentbicycle.restapi.service;

import com.rentbicycle.restapi.model.RentStation;
import com.rentbicycle.restapi.repository.RentStationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentStationService {

    private RentStationRepository rentStationRepository;

    public List<RentStation> getRentStations() {
       return rentStationRepository.findAll();
    }


}
