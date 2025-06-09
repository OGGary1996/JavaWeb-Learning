package com.kezhang.service.impl;

import com.kezhang.dto.EmployeeCreateDTO;
import com.kezhang.dto.EmployeeRequestDTO;
import com.kezhang.dto.EmployeeResponseDTO;
import com.kezhang.dto.EmployeeUpdateDTO;
import com.kezhang.entity.Employee;
import com.kezhang.mapper.EmployeeMapper;
import com.kezhang.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {
        List<EmployeeResponseDTO> employeeResponseDTOS = employeeMapper.getAllEmployees().stream()
                .map(employee -> {
                    EmployeeResponseDTO dto = new EmployeeResponseDTO();
                    BeanUtils.copyProperties(employee,dto);
                    return dto;
                }).collect(Collectors.toList());
        return employeeResponseDTOS;
    }

    @Override
    public List<EmployeeResponseDTO> searchEmployeeById(EmployeeRequestDTO employeeRequestDTO) {
        // 将 EmployeeRequestDTO 转换为 Employee 实体类，只包含一个 ID 字段
        Employee searchRequest = new Employee();
        BeanUtils.copyProperties(employeeRequestDTO, searchRequest);
        // 将 Employee 实体类传递给 Mapper 进行查询
        List<EmployeeResponseDTO> employeeResponseDTOS = employeeMapper.searchEmployeeById(searchRequest).stream()
                .map(employee -> {
                    EmployeeResponseDTO dto = new EmployeeResponseDTO();
                    BeanUtils.copyProperties(employee,dto);
                    return dto;
                }).collect(Collectors.toList());

        return employeeResponseDTOS;
    }

    @Override
    public void deleteEmployeeById(EmployeeRequestDTO employeeRequestDTO) {
        // 将 EmployeeRequestDTO 转换为 Employee 实体类，只包含一个 ID 字段
        Employee searchRequest = new Employee();
        BeanUtils.copyProperties(employeeRequestDTO, searchRequest);
        // 将 Employee 实体类传递给 Mapper 进行删除
        employeeMapper.deleteEmployeeById(searchRequest);
    }

    @Override
    public void createEmployee(EmployeeCreateDTO employeeCreateDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeCreateDTO, employee);
        employeeMapper.insertEmployee(employee);
    }

    @Override
    public void updateEmployee(EmployeeUpdateDTO employeeUpdateDTO) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeUpdateDTO, employee);
        employeeMapper.updateEmployee(employee);
    }
}
