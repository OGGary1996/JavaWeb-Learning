package com.kezhang.dao;

import com.kezhang.pojo.Emp;

import java.sql.Connection;
import java.util.List;

public interface EmpDAO {

    /*
    * 数据库的初始化操作
    * @return Connection
    * */
    void dbConnect() throws Exception;

    void dbClose(Connection connection) throws Exception;

    /**
     * 获取所有员工信息
     * @return 员工列表
     */
    List<Emp> getAllEmp() throws Exception;

}
