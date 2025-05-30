package com.kezhang.controller;

import com.kezhang.pojo.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    // 这个方法用于根据搜索条件反馈符合条件的用户信息
    @PostMapping("/user")
    public List<User> searchUser(@RequestBody Map<String,Object> searchForm) throws IOException{
        // 首先进行判断，如果搜索条件为空，则返回所有的用户信息
        if(isAllConditionsEmpty(searchForm)){
            return showUserList();
        }
        // 如果条件不为空，则需要先获取具体的搜索条件
        String userName = (String) searchForm.get("name");
        String userGender = (String) searchForm.get("gender");
        String userAge = (String) searchForm.get("age");
        // 根据搜索条件进行过滤,所有的过滤都是模糊匹配
        List<User> users = showUserList();
        List<User>filteredList =  users.stream().filter(user -> {
            // 使用一个变量flag来反复判断是否符合条件，最终的flag决定了是否符合条件
            boolean flag = true;
            // 1.按照姓名过滤，模糊匹配，忽略大小写
            if(userName != null && !userName.isEmpty()){
                flag = flag && user.getName().toLowerCase().contains(userName.toLowerCase());
            }
            // 2.按照性别过滤，模糊匹配，忽略大小写
            if(userGender != null && !userGender.isEmpty()){
                flag = flag && user.getGender().toString().equals(userGender);
            }
            // 3.按照年龄过滤，模糊匹配，忽略大小写
            if(userAge != null && !userAge.isEmpty()){
                flag = flag && user.getAge().toString().equals(userAge);
            }
            return flag;
        }).toList();

        // 返回结果
        return filteredList;
    }
        

    // 检查所有搜索条件是否为空
    private boolean isAllConditionsEmpty(Map<String,Object> searchForm) {
        if (searchForm == null || searchForm.isEmpty()) {
            return true;
        }
        
        String name = (String) searchForm.get("name");
        Object gender = searchForm.get("gender");
        Object age = searchForm.get("age");
        
        boolean nameEmpty = (name == null || name.trim().isEmpty());
        boolean genderEmpty = (gender == null || 
                                (gender instanceof String && ((String) gender).trim().isEmpty()));
        boolean ageEmpty = (age == null || 
                            (age instanceof String && ((String) age).trim().isEmpty()));
        
        return nameEmpty && genderEmpty && ageEmpty;
    }



    // 这个方法用于返回所有的所有的用户信息
    public List<User> showUserList() throws IOException{
        List<String> rows = new ArrayList<>();
        // 1. 读取users.txt文件,使用IO流读取
        try(
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("users.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in))
        ){
            String line;
            while((line = reader.readLine()) != null){
                rows.add(line);
            }
        }
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

}
