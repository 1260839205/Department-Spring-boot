package com.augo.demo.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author Code Fruit
 * @date 2021/7/9 16:37
 * @Email 126089205@qq.com
 */

/**
 * 部门
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("dep")
public class Department {
    private int department_id;
    private String department_name;
    private String department_address;
}
