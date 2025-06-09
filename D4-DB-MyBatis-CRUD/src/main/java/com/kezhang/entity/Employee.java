package com.kezhang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private Integer salary;
    private Integer reportsTo;
    private Integer officeId;

}
