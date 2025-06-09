package com.kezhang.controller;

import com.kezhang.model.Emp;
import com.kezhang.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpListController {
    private final EmpService empServiceImpl;
    @Autowired
    public EmpListController(EmpService empServiceImpl){
        this.empServiceImpl = empServiceImpl;
    }

    @GetMapping("/employee")
    public List<Emp> printEmpList() throws Exception {
        return empServiceImpl.getEmpList();
    }
}
