package com.kezhang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kezhang.mapper")
public class E1DbMyBatisPlusCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(E1DbMyBatisPlusCrudApplication.class, args);
    }

}
