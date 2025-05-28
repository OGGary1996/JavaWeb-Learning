package com.kezhang.hellospringboot;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResponseAssignController {
    @RequestMapping("/response-assign")
    /*
    * 方式1:直接将空的HttpServletResponse对象传递给assignResponse方法，然后指定。
    * */
/*    public void assignResponse(HttpServletResponse response){
        // 设置响应状态码为404
        response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 设置状态码为404 Not Found
        // 设置响应头
        response.setHeader("Content-Type", "text/plain; charset=UTF-8"); // 设置内容类型为纯文本
        response.setHeader("Custom-Header", "This is a custom header"); // 设置自定义响应头
        // 设置响应体内容
        try {
            response.getWriter().write("This is a custom response body for a 404 error.");
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常信息
        }
    }*/

    /*
    * 方式2:方法返回ResponseEntity， 使用ResponseEntity来指定响应状态码、头部和体内容
    * */
    public ResponseEntity<String> assignResponse(){ // 泛型表示响应体的类型为String
        return ResponseEntity.status(401)
                .header("Content-Type", "text/plain; charset=UTF-8")
                .header("Custom-Header", "This is a custom header")
                .body("This is a custom response body for a 401 error.");
    }

}
