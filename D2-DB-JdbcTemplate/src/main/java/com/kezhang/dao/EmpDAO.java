package com.kezhang.dao;

import com.kezhang.pojo.Emp;
import java.util.List;

public interface EmpDAO {
    /**
     * 获取所有员工信息
     * @return 员工列表
     */
    List<Emp> getAllEmp();
}
