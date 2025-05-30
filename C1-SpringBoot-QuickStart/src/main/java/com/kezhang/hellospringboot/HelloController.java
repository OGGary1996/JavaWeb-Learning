package com.kezhang.hellospringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// 这个注解标记了一个控制器类，表示它可以处理HTTP请求
public class HelloController {
    @RequestMapping("/hello") // 这个注解定义了一个处理HTTP GET请求的端点
    public String printWelcome(String name){
        String welcome = "Hello, " + name + "! Welcome to Spring Boot!";
        System.out.println(welcome);
        return welcome;
    }
}
