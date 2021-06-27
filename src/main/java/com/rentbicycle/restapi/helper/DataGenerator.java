package com.rentbicycle.restapi.helper;

import com.rentbicycle.restapi.model.Bike;
import com.rentbicycle.restapi.model.RentStation;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    private static final String filePath = "src/main/resources/data.sql";
    private static final List<String> availableCities = new ArrayList<>(List.of("New York", "London", "Paris",
            "Berlin"));
    private static final List<String> availableStreets = new ArrayList<>(List.of("High Street 10", "Low Street 33",
            "Random Street 95", "New Street 15", "Old Street 5"));


    private static final List<String> availableColors = new ArrayList<>(List.of("Red", "Blue", "White", "Black"));
    private static final List<String> availableModels = new ArrayList<>(List.of("Trek", "Scott", "Kona", "Marin",
            "Giant", "Cannondale"));

    public static void main(String [] args) {
        try(FileWriter dataSql = new FileWriter(filePath, false)) {
            for(int i = 1; i <= 6; i++) {
                RentStation currentStation = RentStation.builder()
                        .id(i)
                        .city(availableCities.get(i%4))
                        .street(availableStreets.get(i%5))
                        .build();
                dataSql.append("INSERT INTO RENT_STATION(id, city, street) " +
                        "VALUES (" + i + ", '" + currentStation.getCity() + "', '" + currentStation.getStreet() + "')" +
                        ";\n");
            }

            for(int i = 1; i <= 50; i++) {
                Bike currentBike = Bike.builder()
                        .id(i)
                        .rentStationId(Long.valueOf(1 + i/10))
                        .color(availableColors.get(i%4))
                        .model(availableModels.get(i%6))
                        .pin(1025813 + i)
                        .insertedIntoStation(LocalDate.of(2020,5,10).plusDays(i))
                        .build();
                dataSql.append("INSERT INTO BIKE(id, rent_station_id, model, color, pin, inserted_Into_Station) " +
                        "VALUES (" + i + ", " + currentBike.getRentStationId() + ", '" + currentBike.getModel() + "', '" + currentBike.getColor() + "', " +
                        currentBike.getPin() + ", '" + currentBike.getInsertedIntoStation() +"');\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}