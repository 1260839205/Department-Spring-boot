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
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="/css/bootstrap.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <script>
        window.onload = function () {
            var uids = document.getElementsByName("uid");
            document.getElementById("delSeleced").onclick = function () {
                if (confirm("您确定要删除吗？")){
                    var flog = false;
                    for (var i = 0;i < uids.length;i++){
                        if (uids[i].checked){
                            flog = true;
                            break;
                        }
                    }
                    if (flog){
                        var form = document.getElementById("form");
                        form.submit();
                    }
                }
            }
            var selectAll = document.getElementById("selectAll");
            selectAll.onclick = function () {
                if (selectAll.checked){
                    for (var i = 0; i < uids.length; i++){
                        uids[i].checked = true;
                    }
                }else {
                    for (var i = 0; i < uids.length; i++){
                        uids[i].checked = false;
                    }
                }
            }
        }

        function deleteUser(id) {
            if (confirm("您确定要删除吗？")){
                location.href = "/delete/"+id;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <c:if test="${sessionScope.user != null}">
        <div style="float: left;">
            您好${sessionScope.user.staff_name}！欢迎登陆!!!
        </div>
    </c:if>
    <h3 style="text-align: center">员工信息列表</h3>
    <div style="float:left;">
        <form class="form-inline" action="/index" method="get">
            <button type="submit" class="btn btn-default">返回首页</button>
        </form>
    </div>

    <div style="float:left;">
        <form class="form-inline" action="/exit" method="get">
            <button type="submit" class="btn btn-default">注销登录</button>
        </form>
    </div>
    <div style="float: right;margin: 5px;">
        <a class="btn btn-primary" href="/add">添加用户</a>
        <a class="btn btn-primary" id="delSeleced" href="javascript:void(0);">删除选中</a>
    </div>
    <form action="/delete" method="post" id="form">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="selectAll"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>部门</th>
                <th>职位</th>
                <th>权限</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${allStaff}" var="user" varStatus="number">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.staff_id}"></td>
                    <td>${number.count}</td>
                    <td>${user.staff_name}</td>
                    <td>${user.staff_sex}</td>
                    <td>${user.staff_age}</td>
                    <td>${user.department_name}</td>
                    <td>${user.position_name}</td>
                    <td>${user.authority_type}</td>
                    <td><a class="btn btn-default btn-sm" href="/update/${user.staff_id}">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.staff_id});">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</div>
</body>
</html>
