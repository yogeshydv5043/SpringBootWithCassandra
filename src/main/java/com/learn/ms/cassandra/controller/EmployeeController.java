package com.learn.ms.cassandra.controller;

import com.learn.ms.cassandra.dto.request.EmpRequest;
import com.learn.ms.cassandra.dto.response.EmpResponse;
import com.learn.ms.cassandra.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmpResponse> addEmployee(@RequestBody EmpRequest employee) {
        return ResponseEntity.ok(employeeService.create(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpResponse> updateEmployee(@PathVariable UUID id,@RequestBody EmpRequest employee) {
        return ResponseEntity.ok(employeeService.update(id,employee));
    }

    @GetMapping
    public ResponseEntity<List<EmpResponse>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<List<EmpResponse>> getEmployeesByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(employeeService.getByDepartment(department));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpResponse>getEmployeeById(@PathVariable UUID id)
    {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID id) {
        employeeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
