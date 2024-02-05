package com.javaapp.employeemanagementapp;

class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Employee storage is full");
    }
}
