package com.kezhang.controller;

import com.kezhang.pojo.User;
import com.kezhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    private final UserService userServiceImpl;
    @Autowired
    public UserController(UserService userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }

    // 这个方法用于根据搜索条件反馈符合条件的用户信息
    @PostMapping("/user")
    public List<User> searchUser(@RequestBody Map<String,Object> searchForm) throws IOException{
        // 首先进行判断，如果搜索条件为空，则返回所有的用户信息
        if(isAllConditionsEmpty(searchForm)){
            return userServiceImpl.getAllUsers();
        }
        // 否则，进行条件搜索
        String userName = (String) searchForm.get("name");
        String userGender = (String) searchForm.get("gender");
        String userAge = (String) searchForm.get("age");
        return userServiceImpl.getFilteredUsers(userName,userGender,userAge);
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


}
