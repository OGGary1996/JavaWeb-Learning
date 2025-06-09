package com.kezhang.service;

import com.kezhang.dto.EmployeeCreateDTO;
import com.kezhang.dto.EmployeeRequestDTO;
import com.kezhang.dto.EmployeeResponseDTO;
import com.kezhang.dto.EmployeeUpdateDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDTO> getAllEmployees();

    List<EmployeeResponseDTO> searchEmployeeById(EmployeeRequestDTO employeeRequestDTO);

    void deleteEmployeeById(EmployeeRequestDTO employeeRequestDTO);

    void createEmployee(EmployeeCreateDTO employeeCreateDTO);

    void updateEmployee(EmployeeUpdateDTO employeeUpdateDTO);
}
