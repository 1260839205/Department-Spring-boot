<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script>
        function su() {
            var name = document.getElementById("staff_name").value;
            var age = document.getElementById("staff_age").value;
            var username = document.getElementById("pwd_username").value;
            var password = document.getElementById("pwd_password").value;
            if ((name == '' || name == undefined || name == null || name == ' ')||(age == '' || age == undefined || age == null || age == ' ' )
            ||(username == '' || username == undefined || username == null || username == ' ')||(password == '' || password == undefined || password == null || password == ' ')){
                alert("您输入的值有缺省，请检查后重新输入");
                var event = event || window.event;
                event.preventDefault(); // 兼容标准浏览器
                window.event.returnValue = false;
            }
        }
        function re() {
            window.history.go(-1);
        }
    </script>
</head>
<body>
<div class="container">
    <center><h3>添加用户信息</h3></center>
    <form action="/addStaff" id="add" method="post">
        <div class="form-group">
            <label for="staff_name">姓名：</label>
            <input type="text" class="form-control" id="staff_name" name="staff_name" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label>性别：</label>
            <input type="radio" name="staff_sex" value="男" checked="checked"/>男
            <input type="radio" name="staff_sex" value="女"/>女
        </div>

        <div class="form-group">
            <label for="staff_age">年龄：</label>
            <input type="text" class="form-control" id="staff_age" name="staff_age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="department_name">部门：</label>
            <select name="department_name" id="department_name" class="form-control" >
                <option value="研发部" selected="selected">研发部</option>
                <option value="财务部" >财务部</option>
                <option value="运营部">运营部</option>
            </select>
        </div>
        <div class="form-group">
            <label for="position_name">职位：</label>
            <select name="position_name" id="position_name" class="form-control" >
                <option value="助理" selected="selected">助理</option>
                <option value="会计师" >会计师</option>
                <option value="程序员">程序员</option>
                <option value="运营专员">运营专员</option>
            </select>
        </div>

        <div class="form-group">
            <label for="pwd_username">用户名：</label>
            <input type="text" class="form-control" id="pwd_username" name="pwd_username" placeholder="请输入用户名">
        </div>

        <div class="form-group">
            <label for="pwd_password">密码：</label>
            <input type="text" class="form-control" id="pwd_password" name="pwd_password" placeholder="请输入密码">
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" onclick="su()" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" onclick="re()" value="返回" />
        </div>
    </form>
</div>
</body>
</html>