package com.javaapp.employeemanagementapp;

import java.util.HashMap;
import java.util.Map;

public class EmployeeBook {
    private Map<String, Employee> employees;

    public EmployeeBook() {
        employees = new HashMap<>();
    }

    public void addEmployee(Employee employee) {
        String fullName = employee.getFirstName() + " " + employee.getLastName();
        employees.put(fullName, employee);
    }

    public void removeEmployee(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        employees.remove(fullName);
    }

    public Employee findEmployee(String firstName, String lastName) {
        String fullName = firstName + " " + lastName;
        return employees.get(fullName);
    }
}

