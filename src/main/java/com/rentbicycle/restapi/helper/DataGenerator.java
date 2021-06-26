package com.rentbicycle.restapi.helper;

import com.rentbicycle.restapi.model.Bike;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    private static final String filePath = "src/main/resources/data.sql";
    private static final List<String> availableColors = new ArrayList<>(List.of("Red", "Blue", "White", "Black"));
    private static final List<String> availableModels = new ArrayList<>(List.of("Trek", "Scott", "Kona", "Marin",
            "Giant", "Cannondale"));

    public static void main(String [] args) {
        try(FileWriter dataSql = new FileWriter(filePath, false)) {
            for(int i = 1; i <= 50; i++) {
                Bike currentBike = Bike.builder()
                        .id(i)
                        .color(availableColors.get(i%4))
                        .model(availableModels.get(i%6))
                        .pin(1025813 + i)
                        .insertedIntoStation(LocalDate.of(2020,5,10).plusDays(i))
                        .build();
                dataSql.append("INSERT INTO BIKE(id, model, color, pin, inserted_Into_Station) " +
                        "VALUES (" + i + ", '" + currentBike.getModel() + "', '" + currentBike.getColor() + "', " +
                        currentBike.getPin() + ", '" + currentBike.getInsertedIntoStation() +"');\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}