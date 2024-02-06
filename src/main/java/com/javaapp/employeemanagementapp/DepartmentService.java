package com.javaapp.employeemanagementapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;
    private final List<Department> departments;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
        departments = new ArrayList<>();
    }

    public List<Department> getAllDepartments() {
        return departments;
    }

    public Department getDepartmentById(int id) {
        for (Department department : departments) {
            if (department.id() == id) {
                return department;
            }
        }
        return null; // Если отдел с указанным id не найден
    }

    public List<Employee> getEmployeesByDepartment(int departmentId) throws DepartmentNotFoundException {
        Department department = getDepartmentById(departmentId);

        return employeeService.getEmployeesByDepartment(department);
    }

    public int getSalarySumByDepartment(int departmentId) throws DepartmentNotFoundException {
        Department department = getDepartmentById(departmentId);

        List<Employee> employees = employeeService.getEmployeesByDepartment(department);

        int sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }

        return sum;
    }

    public Employee getMaxSalaryByDepartment(int departmentId) throws DepartmentNotFoundException {
        Department department = getDepartmentById(departmentId);

        List<Employee> employees = employeeService.getEmployeesByDepartment(department);

        Employee maxSalaryEmployee = null;
        int maxSalary = 0;

        for (Employee employee : employees) {
            if (employee.getSalary() > maxSalary) {
                maxSalary = employee.getSalary();
                maxSalaryEmployee = employee;
            }
        }

        return maxSalaryEmployee;
    }

    public Employee getMinSalaryByDepartment(int departmentId) throws DepartmentNotFoundException {
        Department department = getDepartmentById(departmentId);

        List<Employee> employees = employeeService.getEmployeesByDepartment(department);

        Employee minSalaryEmployee = null;
        int minSalary = Integer.MAX_VALUE;

        for (Employee employee : employees) {
            if (employee.getSalary() < minSalary) {
                minSalary = employee.getSalary();
                minSalaryEmployee = employee;
            }
        }

        return minSalaryEmployee;
    }



    public Map<Department, List<Employee>> getEmployeesGroupedByDepartment() {
        List<Department> departments = getAllDepartments();
        Map<Department, List<Employee>> employeesByDepartment = new HashMap<>();

        for (Department department : departments) {
            List<Employee> employees = employeeService.getEmployeesByDepartment(department);
            employeesByDepartment.put(department, employees);
        }

        return employeesByDepartment;
    }
}
