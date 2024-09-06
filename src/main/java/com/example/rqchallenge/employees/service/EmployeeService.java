package com.example.rqchallenge.employees.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.rqchallenge.employees.model.Employee;
import com.example.rqchallenge.employees.model.EmployeeListResponse;
import com.example.rqchallenge.employees.model.EmployeeResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@Service
public class EmployeeService {
    
	private final RestTemplate restTemplate;
	public EmployeeService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	private final String BASE_URL = "https://dummy.restapiexample.com/api/v1/";

	Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	public List<Employee> getAllEmployees() {
		logger.info("Processing  getAllEmployees request");
		ResponseEntity<String> responseEntityString = restTemplate.getForEntity(BASE_URL + "employees", String.class);
		logger.info("received response {}", responseEntityString);

		String responseBodyString = responseEntityString.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		EmployeeListResponse response = null;

		try {
			response = mapper.readValue(responseBodyString, EmployeeListResponse.class);
		} catch (JsonMappingException e ) {
			logger.error("Failed to map response to entity", e);
		} catch (JsonProcessingException e) {
			logger.error("Failed to deserialize response", e);
		}

		List<Employee> employeeList = response != null ? response.getData() : null;

		logger.info("Received getAllEmployees response {}", employeeList);

		return employeeList;
	}
    
	public Employee getEmployeeById(String id) {
		logger.info("Processing  getEmployeeById request");
		
		ResponseEntity<String> responseEntityString = restTemplate.getForEntity(BASE_URL + "employee/" + id, String.class);
		logger.info("received response {}", responseEntityString);

		String responseBodyString = responseEntityString.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		EmployeeResponse response = null;

		try {
			response = mapper.readValue(responseBodyString, EmployeeResponse.class);
		} catch (JsonMappingException e ) {
			logger.error("Failed to map response to entity", e);
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			logger.error("Failed to deserialize response", e);
			e.printStackTrace();
		}

		Employee employee = response != null ? (Employee) response.getData() : null;

		logger.info("Received getEmployeeById response {}", employee);

		return employee;
	}
}
