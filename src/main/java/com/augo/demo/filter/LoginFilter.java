package com.augo.demo.filter;

import com.augo.demo.pojo.Authority;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Code Fruit
 * @date 2021/7/10 19:14
 * @Email 126089205@qq.com
 */
@Order(0)

@WebFilter(filterName = "loginFilter",urlPatterns = "/")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        Authority authority = (Authority) request.getSession().getAttribute("authority");
        //获取浏览器请求访问路径
        String URI = request.getRequestURI();

        if (URI.contains("/login.jsp") || URI.contains("/login") || URI.contains("/js/") || URI.contains("/css/") || URI.contains("/fonts/") || URI.contains("/verifyCode")) {
            filterChain.doFilter(request,response);
        }else {
            request.setAttribute("msg","您尚未登陆，没有权限访问");
            request.getRequestDispatcher("/login").forward(request,response);
        }
    }
}
