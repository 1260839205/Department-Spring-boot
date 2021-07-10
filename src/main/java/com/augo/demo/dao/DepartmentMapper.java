package com.augo.demo.dao;

import com.augo.demo.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Code Fruit
 * @date 2021/7/10 18:24
 * @Email 126089205@qq.com
 */
@Mapper
@Repository("positionMapper")
public interface DepartmentMapper {

    /**
     * 查询所有部门
     * @return
     */
    @Select("select * from department")
    List<Department> findDepartment();
}
