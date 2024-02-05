package com.javaapp.employeemanagementapp;

class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("Employee already added");
    }
}
