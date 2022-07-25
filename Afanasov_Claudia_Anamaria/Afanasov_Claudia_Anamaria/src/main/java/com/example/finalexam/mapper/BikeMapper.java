package com.example.finalexam.mapper;

import com.example.finalexam.dto.BikeDTO;
import com.example.finalexam.model.Bike;
import org.springframework.stereotype.Component;

@Component
public class BikeMapper {

    public Bike bikeDtoRoBike(BikeDTO bikeDTO){
        return new Bike(bikeDTO.getBrand(),bikeDTO.getModel(),bikeDTO.getPrice(),bikeDTO.getColor(),bikeDTO.getType());
    }

}
