package com.example.finalexam.exception;

public class MountainException extends RuntimeException {
    public  MountainException() {
        super("Price cannot be less than 20");
    }
}

