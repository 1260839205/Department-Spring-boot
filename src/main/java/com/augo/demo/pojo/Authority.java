package com.augo.demo.pojo;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author Code Fruit
 * @date 2021/7/9 16:37
 * @Email 126089205@qq.com
 */

/**
 * 权限
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component("authority")
public class Authority {
    private int authority_id;
    private String authority_type;
}
