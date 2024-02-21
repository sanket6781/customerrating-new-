package com.hasmat.courseservice.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("Resource Not Found");
    }
    public ResourceNotFoundException(String s) {
        super(s);
    }

}
