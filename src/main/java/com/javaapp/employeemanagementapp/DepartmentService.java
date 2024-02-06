package com.javaapp.employeemanagementapp;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.Comparator;

@Service
public class DepartmentService {
    private EmployeeBook employeeBook;

    public DepartmentService(EmployeeBook employeeBook) {
        this.employeeBook = employeeBook;
    }

    public Employee getEmployeeWithMaxSalaryByDepartment(String department) {
        List<Employee> employees = employeeBook.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public Employee getEmployeeWithMinSalaryByDepartment(String department) {
        List<Employee> employees = employeeBook.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElse(null);
    }

    public List<Employee> getAllEmployeesByDepartment(String department) {
        List<Employee> employees = employeeBook.getAllEmployees();
        return employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toList());
    }

    public Map<String, List<Employee>> getAllEmployeesByDepartments() {
        List<Employee> employees = employeeBook.getAllEmployees();
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
