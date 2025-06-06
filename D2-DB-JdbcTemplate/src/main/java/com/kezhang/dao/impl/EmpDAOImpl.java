package com.kezhang.dao.impl;

import com.kezhang.dao.EmpDAO;
import com.kezhang.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpDAOImpl implements EmpDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public EmpDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Emp> getAllEmp() {
        String sql = "SELECT * FROM employees";
        List<Emp> empList = jdbcTemplate.query(sql,
            (rs, rowNum) -> new Emp(
                rs.getInt("employee_id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("job_title"),
                rs.getInt("salary"),
                rs.getInt("reports_to"),
                rs.getInt("office_id")
            )
        );
        return empList;
    }
}
