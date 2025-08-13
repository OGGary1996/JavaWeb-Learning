package com.kezhang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kezhang.pojo.entity.Student;
import com.kezhang.service.StudentService;
import com.kezhang.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author zhangke
* @description 针对表【student】的数据库操作Service实现
* @createDate 2025-08-06 22:47:53
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




