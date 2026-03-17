package com.example.StudentCrud.exception;

public class ValidationException extends RuntimeException
{
    public ValidationException(String message) {
        super(message);
    }
}
