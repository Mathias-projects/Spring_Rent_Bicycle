package com.rentbicycle.restapi.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Long rentStationId;
    private String model;
    private String color;
    private long pin;
    @CreatedDate
    private LocalDate insertedIntoStation;

    public void editBike(Bike other) {
        model = other.model == null ? model : other.model;
        color = other.color == null ? color : other.color;
        pin = other.pin == 0 ? pin : other.pin;
        insertedIntoStation = other.insertedIntoStation == null ? insertedIntoStation : other.insertedIntoStation;
    }
}
