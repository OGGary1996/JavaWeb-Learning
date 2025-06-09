package com.kezhang.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Employee Request DTO, used for searching or deleting an employee by ID")
public class EmployeeRequestDTO {
    @Schema(description = "Employee ID", example = "33391", required = true)
    private Integer employeeId;
}
