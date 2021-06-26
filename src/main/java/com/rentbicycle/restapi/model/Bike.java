package com.rentbicycle.restapi.model;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String model;
    private String color;
    private long pin;
    @CreatedDate
    private LocalDate insertedIntoStation;
}
