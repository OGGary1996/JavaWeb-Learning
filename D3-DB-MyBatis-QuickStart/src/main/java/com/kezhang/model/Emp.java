package com.kezhang.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter, toString, equals, hashCode
@AllArgsConstructor // 全参构造函数
@NoArgsConstructor // 无参构造函数
public class Emp {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private Integer salary;
    private Integer reportsTo;
    private Integer officeId;
}
