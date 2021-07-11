<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>首页</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
  </head>
  <body>
  <div align="center">

      <div style="float: left;">
        <p style="text-decoration:none;font-size:25px">
          <c:if test="${sessionScope.user != null}">
            您好${sessionScope.user.staff_name}！欢迎登陆!!!
          </c:if>
        </p>
      </div>
  </div>
  <div style=" width:300px; margin:0 auto;">
    <a href="/list" style="text-decoration:none;font-size:33px" >查询所有部门信息</a>
    <c:forEach items="${departmentList}" var="department" varStatus="number">
        <a href="/list/${department.department_id}" style="text-decoration:none;font-size:33px" ><p>查询${department.department_name}信息&nbsp;&nbsp;&nbsp;&nbsp;</p></a>
    </c:forEach>
  </div>
  </body>
</html>