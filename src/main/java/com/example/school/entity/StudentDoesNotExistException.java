package com.example.school.entity;

public class StudentDoesNotExistException extends RuntimeException {
    public StudentDoesNotExistException(String message) {
        super(message);
    }
}
