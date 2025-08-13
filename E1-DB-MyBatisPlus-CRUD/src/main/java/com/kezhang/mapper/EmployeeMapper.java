package com.kezhang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kezhang.pojo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
// 继承 BaseMapper<T> 接口，MyBatis-Plus 会自动生成 CRUD 方法
// 其中的范型 T 是实体类的类型，这里是 Employee；然后对应到数据库中的表 employee
public interface EmployeeMapper extends BaseMapper<Employee> {
}
