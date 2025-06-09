package com.kezhang.mapper;

import com.kezhang.model.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {
    List<Emp> getAllEmps();
}
