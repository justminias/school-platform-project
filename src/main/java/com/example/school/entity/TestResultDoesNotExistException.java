package com.example.school.entity;

public class TestResultDoesNotExistException extends RuntimeException {
    public TestResultDoesNotExistException(String message) {
        super(message);
    }
}
