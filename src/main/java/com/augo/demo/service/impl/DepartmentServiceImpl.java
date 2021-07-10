package com.augo.demo.service.impl;

import com.augo.demo.dao.DepartmentMapper;
import com.augo.demo.pojo.Department;
import com.augo.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Code Fruit
 * @date 2021/7/10 18:21
 * @Email 126089205@qq.com
 */
@Service("positionService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    @Qualifier("positionMapper")
    private DepartmentMapper positionMapper;

    @Override
    public List<Department> findDepartment() {
        return positionMapper.findDepartment();
    }
}
