package com.example.rqchallenge.employees;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class EmployeeService {
    

	private final RestTemplate restTemplate;
	public EmployeeService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	private final String BASE_URL = "https://dummy.restapiexample.com/api/v1/";

	Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	public ResponseEntity<List<Employee>> getAllEmployees() {
		logger.info("Processing  getAllEmployees request");
		
		var response = restTemplate.exchange(BASE_URL + "employees", 
			HttpMethod.GET, 
			null, 
			new ParameterizedTypeReference<List<Employee>>() {}
		);

		logger.info("Received getAllEmployees response {}", response);

		return response;
	}
    
}
