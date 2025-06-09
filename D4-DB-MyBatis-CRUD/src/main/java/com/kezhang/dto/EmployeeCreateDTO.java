package com.kezhang.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Employee Create DTO")
public class EmployeeCreateDTO {
    @Schema(description = "Employee ID", example = "33391", required = true)
    private Integer employeeId;
    @Schema(description = "First Name", example = "John", required = true)
    private String firstName;
    @Schema(description = "Last Name", example = "Doe", required = true)
    private String lastName;
    @Schema(description = "Job Title", example = "Software Engineer", required = true)
    private String jobTitle;
    @Schema(description = "Salary", example = "80000", required = true)
    private Integer salary;
    @Schema(description = "Reports To (Manager ID)", example = "33390", required = true)
    private Integer reportsTo;
    @Schema(description = "Office ID", example = "1", required = true)
    private Integer officeId;
}

