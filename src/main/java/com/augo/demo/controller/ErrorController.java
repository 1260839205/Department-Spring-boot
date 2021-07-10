package com.augo.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Code Fruit
 * @date 2021/7/10 20:59
 * @Email 126089205@qq.com
 */
@RestController
public class ErrorController {

    @RequestMapping("/error_auth")
    public String error(){
        return "您暂无权限,<a href = '/index'>点此返回主页面</a>";
    }
}
