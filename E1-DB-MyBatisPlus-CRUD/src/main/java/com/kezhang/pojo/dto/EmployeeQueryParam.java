package com.kezhang.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeQueryParam {
    private Integer id; // 员工ID
    private String username; // 员工用户名
    private String name; // 员工姓名
    private BigDecimal minSalary; // 员工薪资范围
    private BigDecimal maxSalary; // 员工薪资范围
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 用于解析日期格式
    private LocalDate beginDate; // 员工入职日期范围
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 用于解析日期格式
    private LocalDate endDate; // 员工入职日期范围
}
