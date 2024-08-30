package com.example.rqchallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.rqchallenge.employees.Employee;
import com.example.rqchallenge.employees.EmployeeController;
import com.example.rqchallenge.employees.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

	@Test
	void shoudGetAllEmployees() throws IOException {
        List<Employee> expectedBody = List.of(TestDataUtil.EMPLOYEE_1, TestDataUtil.EMPLOYEE_2);
        
        Mockito.when(employeeService.getAllEmployees())
            .thenReturn(new ResponseEntity(expectedBody, HttpStatus.OK));

        ResponseEntity<List<Employee>> actualResponseEntity = employeeController.getAllEmployees();
        
        assertTrue(actualResponseEntity.getStatusCode().is2xxSuccessful());
        assertEquals(expectedBody, actualResponseEntity.getBody());
    }
    
}
