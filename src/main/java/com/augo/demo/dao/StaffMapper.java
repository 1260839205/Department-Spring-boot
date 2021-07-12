package com.augo.demo.dao;

import com.augo.demo.pojo.*;
import org.apache.ibatis.annotations.*;
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

    /**
     * 查询指定部门信息
     * @param id
     * @return
     */
    @Select("select * from unpwd u,staff s,department d,dep_position p,authority a  where s.staff_id = u.pwd_staff_id and s.staff_department_id = d.department_id and s.staff_position_id = p.position_id and s.staff_authority_id = a.authority_id and s.staff_department_id = #{id}")
    List<AllStaff> getStaff(@Param("id")int id);

    @Select("select * from unpwd u,staff s,department d,dep_position p,authority a  where s.staff_id = u.pwd_staff_id and s.staff_department_id = d.department_id and s.staff_position_id = p.position_id and s.staff_authority_id = a.authority_id and s.staff_id = #{id}")
    AllStaff echoStaff(@Param("id") int id);

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


    /**
     * 更新用户信息
     * @param sex
     * @param age
     * @param dep_id
     * @param position_id
     * @param id
     */
    @Update("update staff set staff_sex = #{sex},staff_age = #{age},staff_department_id = #{dep_id},staff_position_id = #{position_id} where staff_id = #{id}")
    void updateStaff(@Param("sex")String sex,@Param("age")int age,@Param("dep_id")int dep_id,@Param("position_id")int position_id,@Param("id")int id);

    /**
     * 删除账号和密码
     * @param id
     */
    @Delete("delete unpwd from unpwd  where pwd_staff_id = #{id}")
    void deleteUnpwd(@Param("id") int id);

    /**
     * 删除staff表内对应id的所有数据
     * @param id
     */
    @Delete("delete staff from staff  where staff_id = #{id}")
    void deleteStaff(@Param("id") int id);

    /**
     * 增加信息到Staff
     * @param name
     * @param sex
     * @param age
     * @param dep_id
     * @param position_id
     * @param authority_id
     */
    @Insert("insert into staff values(null,#{name},#{sex},#{age},#{dep_id},#{position_id},#{authority_id})")
    void addStaff(@Param("name")String name,@Param("sex")String sex,@Param("age")int age,@Param("dep_id")int dep_id,@Param("position_id")int position_id,@Param("authority_id")int authority_id);

    /**
     * 增加信息到Unpwd
     * @param id
     * @param pwd_username
     * @param pwd_password
     */
    @Insert("insert into unpwd values(#{id},#{pwd_username},#{pwd_password})")
    void addUnpwd(@Param("id")int id,@Param("pwd_username")String  pwd_username,@Param("pwd_password")String  pwd_password);

    @Select("select * from staff where staff_name = #{name} and staff_sex = #{sex} and staff_age = #{age} and staff_department_id = #{dep_id} and staff_position_id = #{position_id}")
    Staff findId(@Param("name")String name,@Param("sex")String sex,@Param("age")int age,@Param("dep_id")int dep_id,@Param("position_id")int position_id);
}
