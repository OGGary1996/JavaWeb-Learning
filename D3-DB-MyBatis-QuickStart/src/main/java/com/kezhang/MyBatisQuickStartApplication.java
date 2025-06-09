package com.kezhang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.kezhang.mapper")
public class MyBatisQuickStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisQuickStartApplication.class, args);
	}

}
