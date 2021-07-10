package com.augo.demo.controller;


import com.augo.demo.pojo.Authority;
import com.augo.demo.pojo.Staff;
import com.augo.demo.service.impl.StaffServiceImpl;
import com.augo.demo.utils.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;


/**
 * @author Code Fruit
 * @date 2021/7/9 17:17
 * @Email 126089205@qq.com
 */

@Controller
public class StaffController {

    @Autowired
    @Qualifier("staffService")
    StaffServiceImpl staffService;

    /**
     * 登录
     * @param user
     * @param password
     * @param verifycode
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(String user, String password, String verifycode, HttpSession session, Model model){
        //获取Session域中的验证码值
        String verify_code = (String) session.getAttribute("verify_code");
        session.removeAttribute("verify_code");
        //判断用户输入的验证码是否与Session域中的验证码一致
        if (verifycode != null && verify_code != null &&verify_code.equalsIgnoreCase(verifycode)){
            Map<String, Object> map = staffService.login(user, password);
            if (map != null){
                session.setAttribute("user",map.get("staff"));
                session.setAttribute("authority",map.get("authority"));
                session.setAttribute("department",map.get("department"));
                session.setAttribute("position",map.get("position"));
                return "redirect:index";
            }else {
                model.addAttribute("msg","登录失败，账号或密码错误");
            }
        }else{
            model.addAttribute("msg","验证码错误，请重新输入");
        }
        return "login";
    }

    @RequestMapping("/list/{number}")
    public String listStaff(@PathVariable int number, HttpSession session){

        return "list";
    }

    /**
     * 请求验证码
     * @param request
     * @param resp
     * @throws IOException
     */
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse resp, HttpSession session) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        session.setAttribute("verify_code", text);
        VerificationCode.output(image,resp.getOutputStream());
    }
}
