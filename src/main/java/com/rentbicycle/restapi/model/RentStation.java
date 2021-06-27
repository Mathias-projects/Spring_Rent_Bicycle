package com.rentbicycle.restapi.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String city;
    @OneToMany
    @JoinColumn(name = "rentStationId", updatable = false, insertable = false)
    private List<Bike> bikes;

    @PreRemove
    private void preRemove() {
        for (Bike b : bikes) {
            b.setRentStationId(null);
        }
    }
}
