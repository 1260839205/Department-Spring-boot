package com.augo.demo.service;

import com.augo.demo.pojo.Department;

import java.util.List;

/**
 * @author Code Fruit
 * @date 2021/7/10 18:21
 * @Email 126089205@qq.com
 */
public interface DepartmentService {

    /**
     * 查询部门
     * @return
     */
    List<Department> findDepartment();
}
