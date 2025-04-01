package com.learn.ms.cassandra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Employee {

    @PrimaryKey
    private UUID eid;
    @Column
    private String name;
    @Column
    private String technology;
    @Column
    private String department;
    @Column
    private double salary;
    @Column
    private LocalDate joindate;
}
