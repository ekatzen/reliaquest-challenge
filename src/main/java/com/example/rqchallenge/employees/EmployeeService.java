package com.example.rqchallenge.employees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

	// public List<Employee> getAllEmployees() {
	// 	logger.info("Processing  getAllEmployees request");
	// 	Response response = restTemplate.getForObject("https://dummy.restapiexample.com/api/v1/employees", Response.class);
	// 	logger.info("received response {}", response.toString());

	// 	List<Employee> employees = response != null ? response.data != null ? response.data : null : null;

	// 	// ResponseEntity<List<Employee>> empResponseEntity = restTemplate.exchange(BASE_URL + "employees", HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});

	// 	// ResponseEntity<Object[]> responseEntity =
	// 	// restTemplate.getForEntity(BASE_URL + "employees", Object[].class);
		
	// 	// Object[] objects = responseEntity.getBody();
	// 	// ObjectMapper mapper = new ObjectMapper();
		
	// 	// List<Employee> employeeList = Arrays.stream(objects)
	// 	// .map(object -> mapper.convertValue(object, Employee.class))
	// 	// .collect(Collectors.toList());
		
	// 	// List<Employee> employees = responseEntity.getBody();

	// 	logger.info("Received getAllEmployees response {}", employees);

	// 	return employees;
	// }
    
	public ResponseEntity<Response> getEmployeeById(String id) {
		logger.info("Processing  getEmployeeById request");
		
		ResponseEntity<Response> empResponseEntity = restTemplate.getForEntity(BASE_URL + "employee/" + id, Response.class);

		// ResponseEntity<Object[]> responseEntity =
		// restTemplate.getForEntity(BASE_URL + "employees", Object[].class);
		
		// Object[] objects = responseEntity.getBody();
		// ObjectMapper mapper = new ObjectMapper();
		
		// List<Employee> employeeList = Arrays.stream(objects)
		// .map(object -> mapper.convertValue(object, Employee.class))
		// .collect(Collectors.toList());
		
		// List<Employee> employees = responseEntity.getBody();

		logger.info("Received getEmployeeById response {}", empResponseEntity);

		return empResponseEntity;
	}
}
