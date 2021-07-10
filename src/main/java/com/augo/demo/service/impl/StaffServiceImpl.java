package com.augo.demo.service.impl;

import com.augo.demo.dao.StaffMapper;
import com.augo.demo.pojo.Authority;
import com.augo.demo.pojo.Department;
import com.augo.demo.pojo.Position;
import com.augo.demo.pojo.Staff;
import com.augo.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Code Fruit
 * @date 2021/7/9 17:14
 * @Email 126089205@qq.com
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    @Qualifier("staffMapper")
    private StaffMapper staffMapper;

    /**
     * 业务登录
     * @param username
     * @param password
     * @return
     */
    @Override
    public Map<String,Object> login(String username , String password){
        Staff staff = staffMapper.login(username,password);

        if (staff != null){//当用户存在时，封装用户所有的信息
            Authority authority = staffMapper.login_Authority(staff.getStaff_authority_id());
            Department department = staffMapper.login_Department(staff.getStaff_department_id());
            Position position = staffMapper.login_Position(staff.getStaff_position_id());
            Map<String,Object> staffMap = new HashMap<>();
            staffMap.put("staff",staff);
            staffMap.put("authority",authority);
            staffMap.put("department",department);
            staffMap.put("position",position);

            return staffMap;
        }
        return null;
    }
}
