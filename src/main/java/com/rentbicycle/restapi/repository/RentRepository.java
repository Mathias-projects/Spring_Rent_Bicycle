package com.rentbicycle.restapi.repository;

import com.rentbicycle.restapi.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long> {
}
