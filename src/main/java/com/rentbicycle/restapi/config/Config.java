package com.rentbicycle.restapi.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
   private ObjectMapper objectMapper;

   void customizeObjectMapper() {
       objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
   }
}
