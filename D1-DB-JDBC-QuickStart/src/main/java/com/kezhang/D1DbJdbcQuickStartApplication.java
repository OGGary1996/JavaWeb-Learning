package com.kezhang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class D1DbJdbcQuickStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(D1DbJdbcQuickStartApplication.class, args);
    }

}
