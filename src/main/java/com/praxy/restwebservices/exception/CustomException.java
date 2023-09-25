package com.praxy.restwebservices.exception;

public class CustomException extends RuntimeException {
    public CustomException(String errorMessage) {
        super(errorMessage);
    }

}
