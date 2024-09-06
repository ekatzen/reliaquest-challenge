package com.example.rqchallenge;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import com.example.rqchallenge.employees.model.Employee;
import com.fasterxml.jackson.databind.ObjectReader;

public class TestDataUtil {

    public static final Employee EMPLOYEE_1 = new Employee(1, "Tiger Nixon", 320800, 61, "");

    public static final Employee EMPLOYEE_2 = new Employee(2, "test123", 123456, 23, "");

    public String fileToString(String path) throws IOException, URISyntaxException {
        Path file = null;
        try {
            URI uri = new URI(path);
            file = Paths.get(uri);
        } catch (URISyntaxException e) {
            e.getStackTrace();
            return null;
        }

        try {
            if (file != null){
                return Files.readString(file);
            } else {
                return null;
            }
        } catch (IOException e) {
            e.getStackTrace();
            return null;
        }
    }
}
