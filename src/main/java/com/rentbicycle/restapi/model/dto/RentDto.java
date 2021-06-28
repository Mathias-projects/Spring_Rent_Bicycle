package com.rentbicycle.restapi.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
public class RentDto {
    private long id;
    private LocalDateTime rentedDate;
    private long userId;
    private BikeDto bike;
    private long rentStationId;
}
