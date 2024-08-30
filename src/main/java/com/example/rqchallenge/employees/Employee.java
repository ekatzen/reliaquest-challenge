package com.example.rqchallenge.employees;


public class Employee {
    private String id;

    private String employeeName;

    private String employeeSalary;

    private String employeeAge;

    private String profileImage;

    public Employee() {}

    public Employee(String id, String employeeName, String employeeSalary, String employeeAge, String profileImage) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
    }

}
