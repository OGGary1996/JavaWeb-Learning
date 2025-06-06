package com.kezhang.service.impl;

import com.kezhang.dao.EmpDAO;
import com.kezhang.pojo.Emp;
import com.kezhang.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    private final EmpDAO empDAOImpl;
    @Autowired
    public EmpServiceImpl(EmpDAO empDAOImpl){
        this.empDAOImpl = empDAOImpl;
    }

    @Override
    public List<Emp> getEmpList() throws Exception {
        // 调用DAO层方法获取所有员工信息
        return empDAOImpl.getAllEmp();
    };
}
