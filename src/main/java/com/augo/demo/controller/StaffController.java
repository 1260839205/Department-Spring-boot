package com.augo.demo.controller;


import com.augo.demo.pojo.AllStaff;
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
import java.util.List;
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
    public String login(String user, String password, String verifycode, HttpSession session, Model model,HttpServletRequest request){
        //获取Session域中的验证码值
        String verify_code = (String) session.getAttribute("verify_code");

        //解决错误提示问题
        if (request.getSession().getAttribute("login_err") != null){
            model.addAttribute("msg",(String)request.getSession().getAttribute("login_err"));
            request.getSession().removeAttribute("login_err");
            return "login";
        }else if (user != null && password != null && verify_code != null){
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
        }
        return "login";
    }

    /**
     * 权限查询
     * @param number
     * @return
     */
    @RequestMapping("/list/{number}")
    public String listStaff(@PathVariable int number,Model model){
        List<AllStaff> staff = staffService.findStaff(number);
        model.addAttribute("allStaff",staff);
        return "list";
    }

    /**
     * 管理员查询
      * @return
     */
    @RequestMapping("/list")
    public String listStaff(Model model){
        List<AllStaff> staff = staffService.findStaff();
        model.addAttribute("allStaff",staff);
        return "list";
    }

    /**
     * 修改用户界面的回显信息
     * @param id
     * @return
     */
    @RequestMapping("/update/{id}")
    public String echoStaff(@PathVariable int id , Model model){
        AllStaff allStaff = staffService.echoStaff(id);
        model.addAttribute("echo_Staff",allStaff);
        return "update";
    }

    /**
     * 更新用户
     * @param allStaff
     * @param session
     * @return
     */
    @PostMapping("/update")
    public String updateStaff(AllStaff allStaff,HttpSession session ){
        Staff staff = (Staff) session.getAttribute("user");
        staffService.updateStaff(allStaff);
        if (staff.getStaff_authority_id() != 10000) {
            return "forward:list/" + staff.getStaff_department_id();
        }else {
            return "forward:list";
        }
    }

    /**
     * 删除指定人
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deleteStaff(@PathVariable int id,HttpSession session){
        Staff staff = (Staff) session.getAttribute("user");
        staffService.deleteStaff(id);
        if (staff.getStaff_authority_id() != 10000) {
            return "redirect:list/" + staff.getStaff_department_id();
        }else {
            return "redirect:list";
        }
    }

    /**
     * 批量删除用户
     * @param uid
     * @param session
     * @return
     */
    @PostMapping("/delete")
    public String deleteSelect(int[] uid,HttpSession session){
        Staff staff = (Staff) session.getAttribute("user");
        for (int i = 0; i < uid.length; i++) {
            staffService.deleteStaff(uid[i]);
        }
        if (staff.getStaff_authority_id() != 10000) {
            return "redirect:list/" + staff.getStaff_department_id();
        }else {
            return "redirect:list";
        }
    }

    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        return "add";
    }


    /**
     * 添加一个用户
     * @param allStaff
     * @param session
     * @return
     */
    @PostMapping("/addStaff")
    public String addStaff(AllStaff allStaff ,HttpSession session){
        Staff staff = (Staff) session.getAttribute("user");
        staffService.addStaff(allStaff);
        if (staff.getStaff_authority_id() != 10000) {
            return "redirect:list/" + staff.getStaff_department_id();
        }else {
            return "redirect:list";
        }
    }

    @GetMapping("/exit")
    public String exit(HttpSession session){
        session.removeAttribute("user");
        return "login";
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
