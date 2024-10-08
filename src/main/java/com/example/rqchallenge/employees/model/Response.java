package com.example.rqchallenge.employees.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Response {
    String status;

    String message;

    @JsonCreator
    public Response(
        @JsonProperty(value = "status") String status, 
        @JsonProperty(value = "message") String message) {
        this.status = status;
        this.message = message;
    }
}
