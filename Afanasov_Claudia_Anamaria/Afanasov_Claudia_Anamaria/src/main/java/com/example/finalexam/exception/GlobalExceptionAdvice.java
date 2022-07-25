package com.example.finalexam.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler({MountainException.class})
    public ResponseEntity handle(MountainException e) {
        return ResponseEntity.badRequest().body(e.getMessage()) ;
    }
    @ExceptionHandler({TouringException.class})
    public ResponseEntity handle(TouringException e) {
        return ResponseEntity.badRequest().body(e.getMessage()) ;
    }
    @ExceptionHandler({RoadException.class})
    public ResponseEntity handle(RoadException e) {
        return ResponseEntity.badRequest().body(e.getMessage()) ;
    }
}
