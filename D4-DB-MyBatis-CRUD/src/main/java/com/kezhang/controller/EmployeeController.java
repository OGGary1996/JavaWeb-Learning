package com.kezhang.controller;

import com.kezhang.dto.EmployeeCreateDTO;
import com.kezhang.dto.EmployeeRequestDTO;
import com.kezhang.dto.EmployeeResponseDTO;
import com.kezhang.dto.EmployeeUpdateDTO;
import com.kezhang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/getAllEmployees")
    public List<EmployeeResponseDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping("/searchEmployee")
    public List<EmployeeResponseDTO> searchEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return employeeService.searchEmployeeById(employeeRequestDTO);
    }

    @PostMapping("/deleteEmployee")
    public void deleteEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        employeeService.deleteEmployeeById(employeeRequestDTO);
    }

    @PostMapping("/insertEmployee")
    public void insertEmployee(@RequestBody EmployeeCreateDTO employeeCreateDTO){
        employeeService.createEmployee(employeeCreateDTO);
    }

    @PostMapping("/updateEmployee")
    public void updateEmployee(@RequestBody EmployeeUpdateDTO employeeUpdateDTO){
        employeeService.updateEmployee(employeeUpdateDTO);
    }
}
