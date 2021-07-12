package com.augo.demo.service.impl;

import com.augo.demo.dao.StaffMapper;
import com.augo.demo.pojo.*;
import com.augo.demo.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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

    /**
     * 管理员查询
     * @return
     */
    @Override
    public List<AllStaff> findStaff() {
        return staffMapper.findStaff();
    }

    /**
     * 部门经理查询
     * @param number
     * @return
     */
    @Override
    public List<AllStaff> findStaff(int number) {
        return staffMapper.getStaff(number);
    }

    /**
     * 数据回显
     * @param id
     * @return
     */
    @Override
    public AllStaff echoStaff(int id) {
        return staffMapper.echoStaff(id);
    }

    /**
     * 更新数据
     * @param allStaff
     */
    @Override
    public void updateStaff(AllStaff allStaff) {
        if("研发部".equals(allStaff.getDepartment_name())){
            allStaff.setDepartment_id(1001);
        }else if ("财务部".equals(allStaff.getDepartment_name())){
            allStaff.setDepartment_id(1002);
        }else if ("运营部".equals(allStaff.getDepartment_name())){
            allStaff.setDepartment_id(1003);
        }
        if ("部门经理".equals(allStaff.getPosition_name())){
            allStaff.setPosition_id(101);
        }else if ("助理".equals(allStaff.getPosition_name())){
            allStaff.setPosition_id(102);
        }else if ("会计师".equals(allStaff.getPosition_name())){
            allStaff.setPosition_id(103);
        }else if ("程序员".equals(allStaff.getPosition_name())){
            allStaff.setPosition_id(104);
        }else if ("运营专员".equals(allStaff.getPosition_name())){
            allStaff.setPosition_id(105);
        }
        staffMapper.updateStaff(allStaff.getStaff_sex(),allStaff.getStaff_age(),allStaff.getDepartment_id(),allStaff.getPosition_id(),allStaff.getStaff_id());
    }

    @Override
    public void deleteStaff(int id) {
        //先删除账号密码
        staffMapper.deleteUnpwd(id);

        //再删除用户表数据
        staffMapper.deleteStaff(id);
    }

    @Override
    public void addStaff(AllStaff allStaff) {
        if("研发部".equals(allStaff.getDepartment_name())){
            allStaff.setDepartment_id(1001);
        }else if ("财务部".equals(allStaff.getDepartment_name())){
            allStaff.setDepartment_id(1002);
        }else if ("运营部".equals(allStaff.getDepartment_name())){
            allStaff.setDepartment_id(1003);
        }
        if ("部门经理".equals(allStaff.getPosition_name())){
            allStaff.setPosition_id(101);
        }else if ("助理".equals(allStaff.getPosition_name())){
            allStaff.setPosition_id(102);
        }else if ("会计师".equals(allStaff.getPosition_name())){
            allStaff.setPosition_id(103);
        }else if ("程序员".equals(allStaff.getPosition_name())){
            allStaff.setPosition_id(104);
        }else if ("运营专员".equals(allStaff.getPosition_name())){
            allStaff.setPosition_id(105);
        }

        //添加信息到主表
        staffMapper.addStaff(allStaff.getStaff_name(),allStaff.getStaff_sex(),allStaff.getStaff_age(),allStaff.getDepartment_id(),allStaff.getPosition_id(),10001);

        //查询自动增长的id
        Staff id = staffMapper.findId(allStaff.getStaff_name(), allStaff.getStaff_sex(), allStaff.getStaff_age(), allStaff.getDepartment_id(), allStaff.getPosition_id());

        System.out.println("查询验证："+id);
        //添加信息到用户密码表
        staffMapper.addUnpwd(id.getStaff_id(), allStaff.getPwd_username(), allStaff.getPwd_password());
    }


}
