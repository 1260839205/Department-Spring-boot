package com.augo.demo.service;

import com.augo.demo.dao.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Code Fruit
 * @date 2021/7/9 17:11
 * @Email 126089205@qq.com
 */

public interface StaffService {

    Map<String,Object> login(String username , String password);
}
