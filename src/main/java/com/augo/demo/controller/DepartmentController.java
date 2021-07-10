package com.augo.demo.controller;

import com.augo.demo.pojo.Department;
import com.augo.demo.pojo.Position;
import com.augo.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Code Fruit
 * @date 2021/7/10 18:17
 * @Email 126089205@qq.com
 */
@Controller
public class DepartmentController {

    @Autowired
    @Qualifier("positionService")
    DepartmentService positionService;

    @GetMapping("/index")
    public String findPosition(Model model){
        List<Department> departmentList = positionService.findDepartment();
        departmentList.remove(0);
        model.addAttribute("departmentList",departmentList);
        return "index";
    }
}
