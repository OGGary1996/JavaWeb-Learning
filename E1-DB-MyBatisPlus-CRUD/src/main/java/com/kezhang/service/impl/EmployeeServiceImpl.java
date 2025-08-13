package com.kezhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kezhang.pojo.entity.Employee;
import com.kezhang.mapper.EmployeeMapper;
import com.kezhang.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {
    // 这里可以添加自定义方法的实现
    // 由于已经继承了 ServiceImpl 和 EmployeeService，基本的 CRUD 操作已经具备
    // 如果需要添加其他业务逻辑，可以在这里实现
}
