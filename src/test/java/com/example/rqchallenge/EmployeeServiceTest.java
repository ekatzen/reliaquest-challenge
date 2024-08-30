package com.example.rqchallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.rqchallenge.employees.Employee;
import com.example.rqchallenge.employees.EmployeeService;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private EmployeeService employeeService;

    private final String baseUri = "https://dummy.restapiexample.com/api/v1";


    @Test
    void getAllEmployees() {
        List<Employee> expectedBody = List.of(TestDataUtil.EMPLOYEE_1, TestDataUtil.EMPLOYEE_2);
        
        Mockito.when(restTemplate.exchange(baseUri + "/employees", 
        HttpMethod.GET,
            null, 
            new ParameterizedTypeReference<List<Employee>>() {}))
            .thenReturn(new ResponseEntity(expectedBody, HttpStatus.OK));

        ResponseEntity<List<Employee>> actualResponseEntity = employeeService.getAllEmployees();
        
        assertTrue(actualResponseEntity.getStatusCode().is2xxSuccessful());
        assertEquals(expectedBody, actualResponseEntity.getBody());
    }

}