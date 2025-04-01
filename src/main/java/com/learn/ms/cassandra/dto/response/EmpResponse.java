package com.learn.ms.cassandra.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
public class EmpResponse {

    private UUID eid;
    private String name;
    private String technology;
    private String department;
    private double salary;
    private LocalDate joindate;
}
