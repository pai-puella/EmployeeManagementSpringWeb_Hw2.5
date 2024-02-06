package com.javaapp.employeemanagementapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public ResponseEntity<?> getEmployeesByDepartment(@PathVariable int id) {
        try {
            return ResponseEntity.ok(departmentService.getEmployeesByDepartment(id));
        } catch (DepartmentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/salary/sum")
    public ResponseEntity<?> getSalarySumByDepartment(@PathVariable int id) {
        try {
            return ResponseEntity.ok(departmentService.getSalarySumByDepartment(id));
        } catch (DepartmentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/salary/max")
    public ResponseEntity<?> getMaxSalaryByDepartment(@PathVariable int id) {
        try {
            return ResponseEntity.ok(departmentService.getMaxSalaryByDepartment(id));
        } catch (DepartmentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/salary/min")
    public ResponseEntity<?> getMinSalaryByDepartment(@PathVariable int id) {
        try {
            return ResponseEntity.ok(departmentService.getMinSalaryByDepartment(id));
        } catch (DepartmentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getEmployeesGroupedByDepartment() {
        return ResponseEntity.ok(departmentService.getEmployeesGroupedByDepartment());
    }
}
