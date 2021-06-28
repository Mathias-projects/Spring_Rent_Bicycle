package com.rentbicycle.restapi.service;

import com.rentbicycle.restapi.model.Rent;
import com.rentbicycle.restapi.repository.RentRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentService {

    private final RentRepository rentReposity;
    private final static int PAGE_SIZE = 20;

    public Rent getSingleRent(long id) {
        return rentReposity.getById(id);
    }

    public Page<Rent> getRents(int page, Sort.Direction sort) {
        return rentReposity.findAll(PageRequest.of(page, PAGE_SIZE, Sort.by(sort, "id")));
    }

    public Rent addRent(Rent rent) {
        return rentReposity.save(rent);
    }

    public void deleteRent(long id) {
        rentReposity.deleteById(id);
    }
}
