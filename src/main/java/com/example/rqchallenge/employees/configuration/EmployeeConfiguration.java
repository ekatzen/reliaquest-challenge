package com.example.rqchallenge.employees.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import com.example.rqchallenge.employees.service.EmployeeService;

@Configuration
public class EmployeeConfiguration {
    @Bean
    RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        // restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("https://dummy.restapiexample.com"));
        return restTemplate;
    }

    // @Bean
    // EmployeeService employeeService(RestTemplate restTemplate) {
    //     return employeeService(restTemplate);
    // }
}
   