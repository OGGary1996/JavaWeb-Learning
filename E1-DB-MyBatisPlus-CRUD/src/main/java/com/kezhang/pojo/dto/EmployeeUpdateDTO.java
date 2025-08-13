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
public class EmployeeUpdateDTO {
    private Integer id; // 员工ID
    private String username; // 员工用户名
    private String name; // 员工姓名
    private Integer gender; // 员工性别
    private String phone; // 员工手机号
    private Integer jobTitle; // 来自position表的ID
    private Integer departmentId; // 来自department表的ID
    private BigDecimal salary;
    private String image; // 员工头像图片地址
    @DateTimeFormat(pattern = "yyyy-MM-dd") // 用于解析日期格式
    private LocalDate entryDate; // 员工入职日期
}
