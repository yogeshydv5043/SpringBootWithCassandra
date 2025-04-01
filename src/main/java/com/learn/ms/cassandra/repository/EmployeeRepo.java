package com.learn.ms.cassandra.repository;

import com.learn.ms.cassandra.model.Employee;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepo extends CassandraRepository<Employee, UUID> {
    List<Employee> findByDepartment(String department);
}
