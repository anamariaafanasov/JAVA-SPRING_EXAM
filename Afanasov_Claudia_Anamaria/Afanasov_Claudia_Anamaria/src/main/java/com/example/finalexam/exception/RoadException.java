package com.example.finalexam.exception;

public class RoadException extends RuntimeException {
    public  RoadException() {
        super("Price cannot be more than 15");
    }
}
