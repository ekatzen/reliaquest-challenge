package com.example.rqchallenge.employees.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeListResponse extends Response {

    private List<Employee> data;

    public List<Employee> getData() {
        return data;
    }

    @JsonCreator
    public EmployeeListResponse(
        @JsonProperty(value = "status") String status, 
        @JsonProperty(value = "message") String message,
        @JsonProperty(value = "data") List<Employee> data) {
            super(status, message);
            this.data = data;
    }
    
}
