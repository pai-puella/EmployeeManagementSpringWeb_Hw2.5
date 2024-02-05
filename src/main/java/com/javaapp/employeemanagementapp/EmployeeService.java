package com.javaapp.employeemanagementapp;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

class EmployeeService {
    private static final int MAX_EMPLOYEES = 100;
    private List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public Employee addEmployee(String firstName, String lastName, int salary, String department) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException();
        }

        Employee employee = new Employee(firstName, lastName, salary, department);

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }

        employees.add(employee);

        return employee;
    }

    public void validateData(String data) {
        if (StringUtils.isNotBlank(data)) {
            // Данные прошли проверку
        } else {
            throw new BadRequestException("Данные не могут быть пустыми");
        }
    }

    public Employee removeEmployee(String firstName, String lastName, int salary, String department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName, int salary, String department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
