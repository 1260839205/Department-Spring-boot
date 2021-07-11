package com.augo.demo.dao;

import com.augo.demo.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Code Fruit
 * @date 2021/7/9 16:37
 * @Email 126089205@qq.com
 */

@Mapper
@Repository("staffMapper")
public interface StaffMapper {

    /**
     * 查询所有人信息
     * @return
     */
    @Select("select * from unpwd u,staff s,department d,dep_position p,authority a  where s.staff_id = u.pwd_staff_id and s.staff_department_id = d.department_id and s.staff_position_id = p.position_id and s.staff_authority_id = a.authority_id")
    List<AllStaff> findStaff();

    @Select("select * from unpwd u,staff s,department d,dep_position p,authority a  where s.staff_id = u.pwd_staff_id and s.staff_department_id = d.department_id and s.staff_position_id = p.position_id and s.staff_authority_id = a.authority_id and s.staff_department_id = #{id}")
    List<AllStaff> getStaff(@Param("id")int id);


    /**
     * 登录验证查询
     * @param username
     * @param password
     * @return
     */
//    select s.staff_id,s.staff_name,s.staff_sex,s.staff_age,s.staff_department_id,s.staff_position_id,s.staff_authority_id,u.pwd_username,u.pwd_password from staff s join unpwd u on s.staff_id = u.pwd_staff_id where s.staff_id = 100000;
    @Select("select s.staff_id,s.staff_name,s.staff_sex,s.staff_age,s.staff_department_id,s.staff_position_id,s.staff_authority_id,u.pwd_username,u.pwd_password from unpwd u join staff s on s.staff_id = u.pwd_staff_id where pwd_username = #{username} and pwd_password = #{password}")
    Staff login(@Param("username") String username ,@Param("password") String password);


    /**
     * 查询用户权限
     * @param id
     * @return
     */
    @Select("select * from authority where authority_id = #{id}")
    Authority login_Authority(@Param("id") int id);

    /**
     * 查询用户部门
     * @param id
     * @return
     */
    @Select("select * from department where department_id = #{id}")
    Department login_Department(@Param("id") int id);

    /**
     * 查询用户职位
     * @param id
     * @return
     */
    @Select("select * from dep_position where position_id = #{id}")
    Position login_Position(@Param("id") int id);
}
