package com.learn.ms.cassandra.service;


import com.learn.ms.cassandra.dto.request.EmpRequest;
import com.learn.ms.cassandra.dto.response.EmpResponse;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    public EmpResponse create(EmpRequest empRequest);

    public EmpResponse getById(UUID id);

    public EmpResponse update(UUID id,EmpRequest empRequest);

    public List<EmpResponse> getByDepartment(String department);

    public void delete(UUID id);

    public List<EmpResponse> getAll();
}
