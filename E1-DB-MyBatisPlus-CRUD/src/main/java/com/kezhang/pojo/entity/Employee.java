package com.kezhang.pojo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
// 这个注解的作用是将这个类映射到数据库中的表
// 这里的表名是 employee，MyBatis-Plus 会自动将这个类的字段映射到表中的列
// 注意：如果表名和类名不一致，需要在 @TableName 注解中指定表名
@TableName("employee")
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    // 这个注解的作用是将这个字段映射到数据库中的主键,并且使用自增策略
    // 注意：必须指定主键策略，数据库中定义的策略MyBatis-Plus 不会自动识别
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    // 表示值为 null 时，不出现在 SQL 中，避免覆盖数据库默认值。
    @TableField(insertStrategy = FieldStrategy.NOT_NULL, updateStrategy = FieldStrategy.NOT_NULL)
    private String password;
    private String name;
    private Integer gender;
    private String phone;
    private Integer jobTitle;
    private Integer departmentId;
    private BigDecimal salary;
    @TableField(insertStrategy = FieldStrategy.NOT_NULL, updateStrategy = FieldStrategy.NOT_NULL)
    private String image;
    private LocalDate entryDate;
    // 这个注解的作用是将这个字段映射到数据库中的列，并且在插入和更新时自动填充
    // 注意：即使数据库中已经指定了默认值时间戳，MyBatis-Plus中也建议使用这个注解来确保数据的一致性，避免被覆盖为 null
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
