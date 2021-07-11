package com.augo.demo.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author Code Fruit
 * @date 2021/7/11 11:37
 * @Email 126089205@qq.com
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("allStaff")
public class AllStaff {
    private int staff_id; //员工编号
    private String staff_name;//员工姓名
    private String staff_sex; //员工性别
    private int staff_age; //员工年龄
    private int staff_department_id; //所属部门id
    private int staff_position_id;  //所属职位id
    private int staff_authority_id; //权限
    private String pwd_username; //用户名
    private String pwd_password;    //密码

    private int department_id;
    private String department_name;
    private String department_address;

    private int position_id;
    private String position_name;

    private int authority_id;
    private String authority_type;
}
