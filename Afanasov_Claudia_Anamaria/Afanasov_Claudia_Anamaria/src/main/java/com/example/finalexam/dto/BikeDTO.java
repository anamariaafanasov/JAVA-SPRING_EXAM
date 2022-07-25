package com.example.finalexam.dto;

import com.example.finalexam.model.BikeType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BikeDTO {
    @NotBlank
    @Size(max = 200)
    private String brand;
    @NotBlank
    @Size(max = 200)
    private String model;
    @NotNull
    @Min(0)
    private float price;
    @Size(max = 50)
    private String color;
    private BikeType type;

    public BikeDTO() {
    }

    public BikeDTO(@NotBlank @Size(max = 200) String brand, @NotBlank @Size(max = 200) String model, @NotNull @Min(0) float price, @Size(max = 50) String color, BikeType type) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.color = color;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }
}
