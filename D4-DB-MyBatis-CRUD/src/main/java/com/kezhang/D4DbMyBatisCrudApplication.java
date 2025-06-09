package com.kezhang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kezhang.mapper")
public class D4DbMyBatisCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(D4DbMyBatisCrudApplication.class, args);
    }

}
