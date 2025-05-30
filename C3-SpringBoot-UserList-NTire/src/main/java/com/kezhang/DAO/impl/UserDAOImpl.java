package com.kezhang.DAO.impl;

import com.kezhang.DAO.UserDAO;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @Override
    public List<String> getData() throws IOException{
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
            return rows;
        }
    }
}
