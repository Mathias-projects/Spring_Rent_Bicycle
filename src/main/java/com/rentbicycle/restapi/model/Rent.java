package com.rentbicycle.restapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime rentedDate;
    private long userId;
    @OneToOne
    @JoinColumn(name = "bikeId")
    private Bike bike;
    private long rentStationId;

    @PreRemove
    void preRemove() {
        if (bike != null) {
            bike.setRent(null);
        }
    }
}
