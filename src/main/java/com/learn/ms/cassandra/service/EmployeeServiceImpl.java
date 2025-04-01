package com.learn.ms.cassandra.service;

import com.learn.ms.cassandra.dto.request.EmpRequest;
import com.learn.ms.cassandra.dto.response.EmpResponse;
import com.learn.ms.cassandra.exception.ResourceNotFoundException;
import com.learn.ms.cassandra.model.Employee;
import com.learn.ms.cassandra.repository.EmployeeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    // Save a new employee
    @Override
    public EmpResponse create(EmpRequest empRequest) {
        Employee employee = new Employee();
        EmpResponse empResponse = new EmpResponse();
        employee.setEid(UUID.randomUUID());
        employee.setJoindate(LocalDate.now());
        BeanUtils.copyProperties(empRequest, employee);
        employee = employeeRepo.save(employee);
        BeanUtils.copyProperties(employee, empResponse);
        return empResponse;
    }

    // Get all employees
    @Override
    public List<EmpResponse> getAll() {
        return employeeRepo.findAll().stream().map(employee -> {
            EmpResponse empResponse = new EmpResponse();
            BeanUtils.copyProperties(employee, empResponse);
            return empResponse;
        }).toList();
    }

    // Update employee by ID
    @Override
    public EmpResponse update(UUID id, EmpRequest empRequest) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not found !!"));
        EmpResponse empResponse = new EmpResponse();
        BeanUtils.copyProperties(empRequest, employee);
        employee=employeeRepo.save(employee);
        BeanUtils.copyProperties(employee, empResponse);
        return empResponse;
    }


    // Get employees by department
    @Override
    public List<EmpResponse> getByDepartment(String department) {
        List<Employee> employee = employeeRepo.findByDepartment(department);
        return employee.stream().map(employee1 -> {
            EmpResponse empResponse = new EmpResponse();
            BeanUtils.copyProperties(employee1, empResponse);
            return empResponse;
        }).toList();
    }

    // Get employee by ID
    @Override
    public EmpResponse getById(UUID id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not found !!"));
        EmpResponse empResponse = new EmpResponse();
        BeanUtils.copyProperties(employee, empResponse);
        return empResponse;
    }

    // Delete employee by ID
    @Override
    public void delete(UUID id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("employee not found !!"));
        employeeRepo.delete(employee);
    }









}
