package com.kezhang.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseDTO {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private Integer salary;
    private Integer reportsTo;
    private Integer officeId;
}
