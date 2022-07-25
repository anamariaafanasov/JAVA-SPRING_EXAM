package com.example.finalexam.model;

public class Bike {

    private int id;
    private String brand;
    private String model;
    private float price;
    private String color;
    private BikeType type;

    public Bike() {
    }

    public Bike(int id, String brand, String model, float price, String color, BikeType type) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.color = color;
        this.type = type;
    }

    public Bike(int id, String brand, String model, float price, BikeType type) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.type = type;
    }

    public Bike(String brand, String model, float price, String color, BikeType type) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.color = color;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    public void setTypeString(String type) {
        this.type = BikeType.valueOf(type);
    }
}
