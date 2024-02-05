package com.javaapp.employeemanagementapp;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalaryByDepartment(@RequestParam("departmentId") String departmentId) {
        return departmentService.getEmployeeWithMaxSalaryByDepartment(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalaryByDepartment(@RequestParam("departmentId") String departmentId) {
        return departmentService.getEmployeeWithMinSalaryByDepartment(departmentId);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployeesByDepartment(@RequestParam("departmentId") String departmentId) {
        return departmentService.getAllEmployeesByDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map<String, List<Employee>> getAllEmployeesByDepartments() {
        return departmentService.getAllEmployeesByDepartments();
    }
}

