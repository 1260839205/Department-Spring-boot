package com.augo.demo.pojo;

/**
 * @author Code Fruit
 * @date 2021/7/9 16:38
 * @Email 126089205@qq.com
 */

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * 职位表
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("position")
public class Position {
    private int position_id;
    private String position_name;
}
