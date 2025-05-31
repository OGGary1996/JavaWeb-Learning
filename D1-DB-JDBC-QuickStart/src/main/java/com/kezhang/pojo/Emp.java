package com.kezhang.pojo;

import lombok.*;

@Data // getter, setter, toString, equals, hashCode
@AllArgsConstructor // 全参构造函数
@NoArgsConstructor // 无参构造函数
public class Emp {
    private Integer employee_id;
    private String first_name;
    private String last_name;
    private String job_title;
    private Integer salary;
    private Integer reports_to;
    private Integer office_id;
}
