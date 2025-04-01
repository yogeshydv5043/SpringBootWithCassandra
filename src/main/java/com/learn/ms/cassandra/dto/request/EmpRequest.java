package com.learn.ms.cassandra.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpRequest {

    private String name;

    private String technology;

    private String department;

    private double salary;

}