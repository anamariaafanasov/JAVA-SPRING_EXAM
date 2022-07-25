package com.example.finalexam.service;

import com.example.finalexam.exception.MountainException;
import com.example.finalexam.exception.RoadException;
import com.example.finalexam.exception.TouringException;
import com.example.finalexam.model.Bike;
import com.example.finalexam.model.BikeType;
import com.example.finalexam.repository.BikeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class BikeService {
    private BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    public Bike createBike(Bike bike){

            if (bike.getType() == BikeType.ROAD) {
                if (bike.getPrice() > 15)
                    throw new RoadException();
            }
            else if (bike.getType() == BikeType.MOUNTAIN)
            {
                if (bike.getPrice() < 20)
                    throw new MountainException();
            }
            else if (bike.getType() == BikeType.TOURING)
                if (bike.getPrice() < 25)
                    throw new TouringException();
        return bikeRepository.createBike(bike);
    }

    public List<Bike> getBikesBy(String brand, BikeType type ){


        return bikeRepository.getBikesBy(brand, type);
    }
}
