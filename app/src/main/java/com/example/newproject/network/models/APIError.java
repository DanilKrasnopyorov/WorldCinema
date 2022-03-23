package com.example.newproject.network.models;

public class APIError {
    private String error;
    public APIError(String error){
        this.error = error;
    }
    public String message(){
        return error;
    }
}
