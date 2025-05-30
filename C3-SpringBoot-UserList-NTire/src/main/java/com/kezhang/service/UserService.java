package com.kezhang.service;

import com.kezhang.pojo.User;

import java.io.IOException;
import java.util.List;

public interface UserService {
    // 这个方法用于根据DAO中返回的原始数据进行处理,返回所有的用户信息
    List<User> getAllUsers() throws IOException;

    // 这个方法用于条件搜索与过滤
    List<User> getFilteredUsers(String ... searchArgs) throws IOException;

}
