package com.kezhang.service.impl;

import com.kezhang.DAO.UserDAO;
import com.kezhang.pojo.User;
import com.kezhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAOImpl;
    @Autowired
    public UserServiceImpl(UserDAO userDAOImpl){
        this.userDAOImpl = userDAOImpl;
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        // 1. 读取users.txt文件,使用IO流读取
        List<String> rows = userDAOImpl.getData();
        // 2. 将读取到的用户数据封装到User对象中,并且形成一个List集合
        List<User> users = rows.stream().map(row -> {
            String[] parts = row.split(",");
            String userName = parts[0];
            String userProfile = parts[1];
            Integer userGender = Integer.parseInt(parts[2]);
            Integer userAge = Integer.parseInt(parts[3]);
            Integer userMajor = Integer.parseInt(parts[4]);
            return new User(userName, userProfile, userGender, userAge, userMajor);
        }).toList();
        // 3.返回数据
        return users;
    }
    @Override
    public List<User> getFilteredUsers(String ... searchArgs) throws IOException {
        List<User> users = getAllUsers();
        List<User>filteredList =  users.stream().filter(user -> {
            // 使用一个变量flag来反复判断是否符合条件，最终的flag决定了是否符合条件
            boolean flag = true;
            // 1.按照姓名过滤，模糊匹配，忽略大小写
            if(searchArgs[0] != null && !searchArgs[0].isEmpty()){
                flag = flag && user.getName().toLowerCase().contains(searchArgs[0].toLowerCase());
            }
            // 2.按照性别过滤，模糊匹配，忽略大小写
            if(searchArgs[1] != null && !searchArgs[1].isEmpty()){
                flag = flag && user.getGender().toString().equals(searchArgs[1]);
            }
            // 3.按照年龄过滤，模糊匹配，忽略大小写
            if(searchArgs[2] != null && !searchArgs[2].isEmpty()){
                flag = flag && user.getAge().toString().equals(searchArgs[2]);
            }
            return flag;
        }).toList();

        // 返回结果
        return filteredList;
    }
}
