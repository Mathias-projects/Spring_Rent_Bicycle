package com.rentbicycle.restapi.repository;

import com.rentbicycle.restapi.model.RentStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentStationRepository extends JpaRepository<RentStation, Long> {

}
