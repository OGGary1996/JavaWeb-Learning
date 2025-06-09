package com.kezhang.service;

import com.kezhang.model.Emp;

import java.util.List;

public interface EmpService {
    /*
    * 定义获取所有员工信息的方法
    * 本案例中没有具体业务逻辑，只是为了展示流程，所以这个接口仅作为示例
    *
    * */
    List<Emp> getEmpList() throws Exception;


}
