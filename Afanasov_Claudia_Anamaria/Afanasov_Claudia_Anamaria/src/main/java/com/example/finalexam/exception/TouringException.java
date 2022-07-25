package com.example.finalexam.exception;

public class TouringException extends RuntimeException {
    public  TouringException() {
        super("Price cannot be less than 25");
    }
}
