package com.kezhang.DAO;

import com.kezhang.pojo.User;

import java.io.IOException;
import java.util.List;

public interface UserDAO {
    /*
    * 用于获取用户的信息并且封装到User对象中，然后组成一个List<User>返回
    * */
    List<String> getData() throws IOException;
}
