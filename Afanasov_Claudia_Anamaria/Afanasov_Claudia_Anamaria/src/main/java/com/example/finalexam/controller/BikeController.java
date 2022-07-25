package com.example.finalexam.controller;

import com.example.finalexam.dto.BikeDTO;
import com.example.finalexam.mapper.BikeMapper;
import com.example.finalexam.model.Bike;
import com.example.finalexam.model.BikeType;
import com.example.finalexam.service.BikeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bikes")
public class BikeController {
    private BikeService bikeService;
    private BikeMapper bikeMapper;

    public BikeController(BikeService bikeService, BikeMapper bikeMapper) {
        this.bikeService = bikeService;
        this.bikeMapper = bikeMapper;
    }

    @PostMapping
    public ResponseEntity<Bike> createBike(@RequestBody @Valid BikeDTO bikeDTO){
        Bike savedBike = bikeService.createBike(bikeMapper.bikeDtoRoBike(bikeDTO));
        return ResponseEntity.created(null).body(savedBike);
    }

    @GetMapping
    public List<Bike> getBikesBy(@RequestParam(required = false)String brand, @RequestParam(required = false) BikeType type ){
        return bikeService.getBikesBy(brand, type);
    }
}
