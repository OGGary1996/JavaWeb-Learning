package com.kezhang.dao.impl;

import com.kezhang.dao.EmpDAO;
import com.kezhang.pojo.Emp;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmpDAOImpl implements EmpDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/sql_hr?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "zhang";
    private static final String JDBC_PASSWORD = "050715";
    private Connection connection;
    private List<Emp> empList = new ArrayList<>();

    @Override
    public void dbConnect() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASSWORD);
        if (connection != null) {
            System.out.println("DB successfully connected！");
            this.connection = connection;
        } else {
            System.out.println("DB failed connected！");
        }
    }
    @Override
    public void dbClose(Connection connection) throws Exception {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("DB closed successfully！");
        } else {
            System.out.println("DB has already been closed or haven't created！");
        }
    }

    @Override
    public List<Emp> getAllEmp() throws Exception {
        this.dbConnect();
        // 创建SQL查询语句
        String sql = "SELECT * FROM ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,"employees");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            // 获取每一行数据
            Integer employee_id = resultSet.getInt("employee_id");
            String first_name = resultSet.getString("first_name");
            String last_name = resultSet.getString("last_name");
            String job_title = resultSet.getString("job_title");
            Integer salary = resultSet.getInt("salary");
            Integer reports_to = resultSet.getInt("reports_to");
            Integer office_id = resultSet.getInt("office_id");

            // 创建Emp对象
            Emp emp = new Emp(employee_id, first_name, last_name, job_title, salary, reports_to, office_id);
            empList.add(emp);
        };

        // 关闭资源
        resultSet.close();
        preparedStatement.close();
        this.dbClose(connection);

        return empList;
    }
}
