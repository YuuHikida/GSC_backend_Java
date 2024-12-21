package com.example.GCS.exception;

public class InvalidTokenException extends RuntimeException {
    public InvalidTokenException(String mes)
    {
        super(mes);
    }
}
