package com.kezhang.service.impl;

import com.kezhang.mapper.EmpMapper;
import com.kezhang.model.Emp;
import com.kezhang.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    private final EmpMapper empMapper;
    @Autowired
    public EmpServiceImpl(EmpMapper empMapper){
        this.empMapper = empMapper;
    }

    @Override
    public List<Emp> getEmpList() throws Exception {
        // 调用DAO层方法获取所有员工信息
        return empMapper.getAllEmps();
    };
}
