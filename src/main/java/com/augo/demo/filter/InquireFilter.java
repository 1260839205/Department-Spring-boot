package com.augo.demo.filter;

import com.augo.demo.pojo.Authority;
import com.augo.demo.pojo.Department;
import com.augo.demo.pojo.Position;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

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
@Order(1)
@Component
@WebFilter(filterName = "inquire",urlPatterns = "/list/*")
public class InquireFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        Authority authority = (Authority) request.getSession().getAttribute("authority");
        Department department = (Department) request.getSession().getAttribute("department");
        Position position  = (Position) request.getSession().getAttribute("position");
        //获取浏览器请求访问路径
        String uri = request.getRequestURI();
        if (uri.contains("/list/1001") || uri.contains("/list/1002") ||uri.contains("/list/1003")) { //判断是否是要拦截的路径
            if (authority.getAuthority_id() == 10000 && position.getPosition_id() == 100 &&department.getDepartment_id() == 1000){//判断是不是超级管理员
                filterChain.doFilter(request,response);
            }else if ( position.getPosition_id() == 101 && authority.getAuthority_id() == 10002){ //判断是否是经理，以及是否拥有查看权限
                if (uri.contains("/list/1001")   && department.getDepartment_id() == 1001 ){//放行研发部经理
                    filterChain.doFilter(request, response);
                }else if (uri.contains("/list/1002")   && department.getDepartment_id() == 1002 ){//放行财务部经理
                    filterChain.doFilter(request, response);
                }else if (uri.contains("/list/1003")  && department.getDepartment_id() == 1003 ){//放行运营部经理
                    filterChain.doFilter(request, response);
                }else{
                    response.sendRedirect("/error_auth");
                }
            }else {
                response.sendRedirect("/error_auth");
            }
        }else {
            filterChain.doFilter(request, response);
        }
    }
}
