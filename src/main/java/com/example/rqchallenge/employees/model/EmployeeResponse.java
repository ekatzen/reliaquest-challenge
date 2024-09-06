package com.example.rqchallenge.employees.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeResponse extends Response {

    private Employee data;

    public Employee getData() {
        return data;
    }

    @JsonCreator
    public EmployeeResponse(
        @JsonProperty(value = "status") String status, 
        @JsonProperty(value = "message") String message,
        @JsonProperty(value = "data") Employee data) {
            super(status, message);
            this.data = data;
    }    
}
