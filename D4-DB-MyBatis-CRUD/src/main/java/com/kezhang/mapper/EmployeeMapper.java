package com.kezhang.mapper;

import com.kezhang.entity.Employee;

import java.util.List;

public interface EmployeeMapper {
    List<Employee> getAllEmployees();
    List<Employee> searchEmployeeById(Employee employee);
    void deleteEmployeeById(Employee employee);
    void insertEmployee(Employee employee);
    void updateEmployee(Employee employee);
}
