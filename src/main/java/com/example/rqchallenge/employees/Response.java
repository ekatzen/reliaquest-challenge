package com.example.rqchallenge.employees;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response {
    String status;

    Employee data;
}
