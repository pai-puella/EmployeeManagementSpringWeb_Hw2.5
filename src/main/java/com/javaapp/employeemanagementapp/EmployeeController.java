package com.javaapp.employeemanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@SpringBootApplication
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam String department) {
        try {
            return employeeService.addEmployee(firstName, lastName, salary, department);
        } catch (EmployeeAlreadyAddedException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee already exists", e);
        } catch (EmployeeStorageIsFullException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee storage is full", e);
        }
    }

    @GetMapping("/employee/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam String department) {
        try {
            return employeeService.removeEmployee(firstName, lastName, salary, department);
        } catch (EmployeeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found", e);
        }
    }

    @GetMapping("/employee/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam String department) {
        try {
            return employeeService.findEmployee(firstName, lastName, salary, department);
        } catch (EmployeeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found", e);
        }
    }

    @GetMapping("/employee/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeController.class, args);
    }
}