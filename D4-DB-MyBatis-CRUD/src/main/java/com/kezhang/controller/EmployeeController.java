package com.kezhang.controller;

import com.kezhang.dto.EmployeeCreateDTO;
import com.kezhang.dto.EmployeeRequestDTO;
import com.kezhang.dto.EmployeeResponseDTO;
import com.kezhang.dto.EmployeeUpdateDTO;
import com.kezhang.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Employee Management System")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Get all employees")
    @GetMapping("/getAllEmployees")
    public List<EmployeeResponseDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @Operation(summary ="Get employee by ID")
    @PostMapping("/searchEmployee")
    public List<EmployeeResponseDTO> searchEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return employeeService.searchEmployeeById(employeeRequestDTO);
    }

    @Operation(summary ="Get employee by name")
    @PostMapping("/deleteEmployee")
    public void deleteEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        employeeService.deleteEmployeeById(employeeRequestDTO);
    }

    @Operation(summary ="Insert a new employee")
    @PostMapping("/insertEmployee")
    public void insertEmployee(@RequestBody EmployeeCreateDTO employeeCreateDTO){
        employeeService.createEmployee(employeeCreateDTO);
    }

    @Operation(summary ="Update an existing employee")
    @PostMapping("/updateEmployee")
    public void updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO){
        employeeService.updateEmployee(employeeUpdateDTO);
    }
}
