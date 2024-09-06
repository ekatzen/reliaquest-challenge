package com.example.rqchallenge.employees.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.rqchallenge.employees.model.Employee;
import com.example.rqchallenge.employees.model.EmployeeList;
import com.example.rqchallenge.employees.model.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
		Response response = null;

		try {
			response = mapper.readValue(responseBodyString, Response.class);
		} catch (JsonMappingException e ) {
			logger.error("Failed to map response to entity", e);
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			logger.error("Failed to deserialize response", e);
			e.printStackTrace();
		}

		EmployeeList employeeList = response != null ? (EmployeeList) response.getData() : null;
		
		// Object[] objects = responseEntity.getBody();
		// ObjectMapper mapper = new ObjectMapper();
		
		// List<Employee> employeeList = Arrays.stream(objects)
		// .map(object -> mapper.convertValue(object, Employee.class))
		// .collect(Collectors.toList());
		
		// List<Employee> employees = responseEntity.getBody();
		List<Employee> employees = employeeList !=null ? employeeList.getEmployees() : null;

		logger.info("Received getAllEmployees response {}", employees);

		return employees;
	}
    
	public Employee getEmployeeById(String id) {
		logger.info("Processing  getEmployeeById request");
		
		ResponseEntity<String> responseEntityString = restTemplate.getForEntity(BASE_URL + "employee/" + id, String.class);

		String responseBodyString = responseEntityString.getBody();
		
		ObjectMapper mapper = new ObjectMapper();
		Response response = null;

		try {
			response = mapper.readValue(responseBodyString, Response.class);
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
