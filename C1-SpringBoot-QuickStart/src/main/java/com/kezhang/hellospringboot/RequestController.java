package com.kezhang.hellospringboot;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @RequestMapping("/request")
    public String printRequestInfo(HttpServletRequest request) {
        // 1.获取请求行中的信息
        String method = request.getMethod(); // 获取请求方法
        String requestURI = request.getRequestURI(); // 获取请求的URI
        String protocol = request.getProtocol(); // 获取协议版本
        String queryString = request.getQueryString(); // 获取查询字符串
        String requestLine = method + " " + requestURI + protocol + (queryString != null ? "?" + queryString : "");
        // 2.获取请求头中的信息
        StringBuilder headers = new StringBuilder();
        request.getHeaderNames().asIterator().forEachRemaining(headerName -> {
            headers.append(headerName) // 获取请求头的名称
                    .append(": ")
                    .append(request.getHeader(headerName)) // 根据名称获取请求头的值
                    .append("\n");
        });
        String headerInfo = headers.toString();
        System.out.println("Request Line: " + requestLine);
        System.out.println("Headers: \n" + headerInfo);

        return "Got Request Info, see console for details.";
    }
}
