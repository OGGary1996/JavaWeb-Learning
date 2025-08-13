package com.kezhang.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName student
 */
@TableName(value ="student")
@Data
public class Student {
    /**
     * Unique identifier for the student
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * Full name of the student
     */
    private String name;

    /**
     * Unique account number for the student
     */
    private String accountNumber;

    /**
     * Gender of the student, 0 -> Female, 1 -> Male
     */
    private Integer gender;

    /**
     * Phone number of the student, 10 digits
     */
    private String phone;

    /**
     * ID card number of the student, 18 digits
     */
    private String idCard;

    /**
     * Residential address of the student
     */
    private String address;

    /**
     * ID of the class the student belongs to, references clazz table
     */
    private Integer clazzId;

    /**
     * Whether the student is from college, 0 -> No, 1 -> Yes
     */
    private Integer isCollege;

    /**
     * Degree type, 0 -> high school, 1 -> bachelor, 2 -> master, 3 -> PhD
     */
    private Integer degree;

    /**
     * Graduation date, format is YYYY-MM-DD
     */
    private Date graduationDate;

    /**
     * Number of violations by the student, default is 0
     */
    private Integer violationCount;

    /**
     * Score for violations, default is 0
     */
    private Integer violationScore;

    /**
     * Creation time of the student record
     */
    private Date createTime;

    /**
     * Last update time of the student record
     */
    private Date updateTime;
}