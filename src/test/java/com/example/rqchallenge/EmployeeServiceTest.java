package com.example.rqchallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileUtils;
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

import com.example.rqchallenge.employees.model.Employee;
import com.example.rqchallenge.employees.model.EmployeeListResponse;
import com.example.rqchallenge.employees.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private EmployeeService employeeService;

    private final String baseUri = "https://dummy.restapiexample.com/api/v1";


    // @Test
    // void getAllEmployees() {
    //     EmployeeListResponse expectedBody = new EmployeeListResponse("success", "Successfully! All records has been fetched", 
    //     List.of(TestDataUtil.EMPLOYEE_1, TestDataUtil.EMPLOYEE_2));
        
    //     Mockito.when(restTemplate.getForEntity(baseUri + "/employees", String.class))
    //         .thenReturn(new ResponseEntity(expectedBody, HttpStatus.OK));

    //     List<Employee> actualResponseEntity = employeeService.getAllEmployees();
        
    //     assertEquals(expectedBody.getData(), actualResponseEntity);
    // }

    @Test
    void deserializeEmployees() throws JsonMappingException, JsonProcessingException {
        String jsonAsString = "[{\"id\":1,\"employee_name\":\"Tiger Nixon\",\"employee_salary\":320800,\"employee_age\":61,\"profile_image\":\"\"},{\"id\":2,\"employee_name\":\"Garrett Winters\",\"employee_salary\":170750,\"employee_age\":63,\"profile_image\":\"\"},{\"id\":3,\"employee_name\":\"Ashton Cox\",\"employee_salary\":86000,\"employee_age\":66,\"profile_image\":\"\"}]";

        Collection<Employee> readValues = new ObjectMapper().readValue(
            jsonAsString, new TypeReference<Collection<Employee>>() {});

            assertEquals(3, readValues.stream().count());
    }

}