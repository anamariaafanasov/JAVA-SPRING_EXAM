package com.example.finalexam;

import com.example.finalexam.exception.MountainException;
import com.example.finalexam.exception.RoadException;
import com.example.finalexam.exception.TouringException;
import com.example.finalexam.model.Bike;
import com.example.finalexam.model.BikeType;
import com.example.finalexam.repository.BikeRepository;
import com.example.finalexam.service.BikeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BikeTestService {
    @Mock
    private BikeRepository bikeRepository;
    @InjectMocks
    private BikeService bikeService;

    @Test
    @DisplayName("Create bike - happy flow")
    void createBike(){
        Bike bike = new Bike("Yamaha", "ceva", 100,"blue", BikeType.MOUNTAIN);
        Bike savedbike = new Bike(1,"Yamaha", "ceva", 100,"blue", BikeType.MOUNTAIN);
        when(bikeRepository.createBike(any())).thenReturn(savedbike);

        Bike result = bikeService.createBike(bike);

        assertEquals(bike.getBrand(), result.getBrand());
        assertEquals(bike.getModel(), result.getModel());
        assertEquals(bike.getPrice(), result.getPrice());
        assertEquals(bike.getColor(), result.getColor());
        assertEquals(bike.getType(), result.getType());

        verify(bikeRepository).createBike(any());
    }

    @Test
    @DisplayName("Create bike - moutain bike less than 20")
    void createBikeThrowsMountainException(){
        Bike bike = new Bike("Yamaha", "ceva", 12,"blue", BikeType.MOUNTAIN);
        Bike savedbike = new Bike(1,"Yamaha", "ceva", 12,"blue", BikeType.MOUNTAIN);

        MountainException exception = assertThrows(MountainException.class,() -> bikeService.createBike(bike));

        assertEquals("Price cannot be less than 20",exception.getMessage());


        verify(bikeRepository,times(0)).createBike(any());
    }

    @Test
    @DisplayName("Create bike - Touring bike less than 25")
    void createBikeThrowsTouringException(){
        Bike bike = new Bike("Yamaha", "ceva", 11,"blue", BikeType.TOURING);
        Bike savedbike = new Bike(1,"Yamaha", "ceva", 11,"blue", BikeType.TOURING);
//        when(bikeRepository.createBike(any())).thenReturn(savedbike);

        TouringException exception = assertThrows(TouringException.class,() -> bikeService.createBike(bike));

        assertEquals("Price cannot be less than 25",exception.getMessage());


        verify(bikeRepository,times(0)).createBike(any());
    }
    @DisplayName("Create bike - Road bike more than 15")
    void createBikeThrowsRoadException(){
        Bike bike = new Bike("Yamaha", "ceva", 72,"blue", BikeType.ROAD);
        Bike savedbike = new Bike(1,"Yamaha", "ceva", 72,"blue", BikeType.ROAD);
//        when(bikeRepository.createBike(any())).thenReturn(savedbike);

        RoadException exception = assertThrows(RoadException.class,() -> bikeService.createBike(bike));

        assertEquals("Price cannot be more than 15",exception.getMessage());


        verify(bikeRepository,times(0)).createBike(any());
    }

    @Test
    @DisplayName("Get bikes")
    void get() {
        Bike bike = new Bike(1,"Yamaha", "ceva", 11,"blue", BikeType.ROAD);
        Bike bike2 = new Bike(2,"Yamahha", "ceva", 11,"blue", BikeType.ROAD);
        when(bikeRepository.getBikesBy("Yamaha",BikeType.ROAD)).thenReturn(List.of(bike));

        List<Bike> result = bikeService.getBikesBy("Yamaha",BikeType.ROAD);

        assertNotNull(result);
        assertEquals(1, result.size());


        verify(bikeRepository).getBikesBy("Yamaha",BikeType.ROAD);
    }

}
