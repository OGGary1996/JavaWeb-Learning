package com.kezhang.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Employee Update DTO")
public class EmployeeUpdateDTO {
    @Schema(description = "Employee ID", example = "33391", required = false)
    private Integer employeeId;
    @Schema(description = "First Name", example = "John", required = false)
    private String firstName;
    @Schema(description = "Last Name", example = "Doe", required = false)
    private String lastName;
    @Schema(description = "Job Title", example = "Software Engineer", required = false)
    private String jobTitle;
    @Schema(description = "Salary", example = "80000", required = false)
    private Integer salary;
    @Schema(description = "Reports To (Manager ID)", example = "33390", required = false)
    private Integer reportsTo;
    @Schema(description = "Office ID", example = "1", required = false)
    private Integer officeId;
}
