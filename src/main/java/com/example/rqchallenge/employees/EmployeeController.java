package com.example.rqchallenge.employees;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController implements IEmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    
    EmployeeService employeeService;
    
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<Employee> createEmployee(Map<String, Object> employeeInput) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<String> deleteEmployeeById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<List<Employee>> getAllEmployees() throws IOException {
        // logger.info("Received getAllEmployees request");
        // var response = employeeService.getAllEmployees();
        // return new ResponseEntity(response, HttpStatus.OK);
        // // return response;
        return null;
    }

    @Override
    public ResponseEntity<Response> getEmployeeById(String id) {
        logger.info("Received getAllEmployees request");
        var response = employeeService.getEmployeeById(id);
        return response;
    }

    @Override
    public ResponseEntity<List<Employee>> getEmployeesByNameSearch(String searchString) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<Integer> getHighestSalaryOfEmployees() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ResponseEntity<List<String>> getTopTenHighestEarningEmployeeNames() {
        // TODO Auto-generated method stub
        return null;
    }
    
    
}
