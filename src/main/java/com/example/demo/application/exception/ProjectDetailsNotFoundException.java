package com.example.demo.application.exception;

public class ProjectDetailsNotFoundException extends RuntimeException{
    public ProjectDetailsNotFoundException(String message){
        super(message);
    }
}
