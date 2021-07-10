package com.augo.demo.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author Code Fruit
 * @date 2021/7/9 16:37
 * @Email 126089205@qq.com
 */

/**
 * 员工
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("staff")
public class Staff {
    private int staff_id;
    private String staff_name;
    private String staff_sex;
    private int staff_age;
    private int staff_department_id;
    private int staff_position_id;
    private int staff_authority_id;
    private String pwd_username;
    private String pwd_password;
}
