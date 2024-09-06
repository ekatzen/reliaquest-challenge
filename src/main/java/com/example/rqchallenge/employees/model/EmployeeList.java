package com.example.rqchallenge.employees.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeList implements ResponseData {
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }
}
