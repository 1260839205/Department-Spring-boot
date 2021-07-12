<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>
        <!-- 1. 导入CSS的全局样式 -->
        <link href="/css/bootstrap.css" rel="stylesheet">
        <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
        <script src="/js/jquery-2.1.0.min.js"></script>
        <!-- 3. 导入bootstrap的js文件 -->
        <script src="/js/bootstrap.min.js"></script>
        <script>
            function re() {
                window.history.go(-1);
            }
            $(function () {
                $("#staff_id").hide();
            });
        </script>
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改用户信息</h3>
        <form action="/update" method="post">
            <input name="staff_id" value="${echo_Staff.staff_id}" id="staff_id">
          <div class="form-group">
            <label for="staff_name">姓名：</label>
            <input type="text" class="form-control" id="staff_name" value="${echo_Staff.staff_name}" name="staff_name"  readonly="readonly" placeholder="请输入姓名" />
          </div>

          <div class="form-group">
            <label>性别：</label>
              <c:if test="${echo_Staff.staff_sex == '男'}">
              <input type="radio" name="staff_sex" checked="checked" value="男"  />男
                <input type="radio" name="staff_sex" value="女"  />女
              </c:if>
              <c:if test="${echo_Staff.staff_sex == '女'}">
                  <input type="radio" name="staff_sex" value="男"  />男
                  <input type="radio" name="staff_sex" checked="checked" value="女"  />女
              </c:if>
          </div>

          <div class="form-group">
            <label for="staff_age">年龄：</label>
            <input type="text" class="form-control" id="staff_age" value="${echo_Staff.staff_age}" name="staff_age" placeholder="请输入年龄" />
          </div>

          <div class="form-group">
            <label for="department_name">部门：</label>
             <select name="department_name" id="department_name" class="form-control" >
                 <c:if test="${echo_Staff.department_name == '研发部'}">
                     <option value="研发部" selected="selected">研发部</option>
                     <option value="财务部" >财务部</option>
                     <option value="运营部">运营部</option>
                 </c:if>
                 <c:if test="${echo_Staff.department_name == '财务部'}">
                     <option value="研发部" >研发部</option>
                     <option value="财务部" selected="selected">财务部</option>
                     <option value="运营部">运营部</option>
                 </c:if>
                 <c:if test="${echo_Staff.department_name == '运营部'}">
                     <option value="研发部" >研发部</option>
                     <option value="财务部" >财务部</option>
                     <option value="运营部" selected="selected">运营部</option>
                 </c:if>
            </select>
          </div>
          <div class="form-group">
                <label for="position_name">职位：</label>
                <select name="position_name" id="position_name" class="form-control" >
                    <c:if test="${echo_Staff.position_name == '助理'}">
                        <option value="部门经理" >部门经理</option>
                        <option value="助理" selected="selected">助理</option>
                        <option value="会计师" >会计师</option>
                        <option value="程序员">程序员</option>
                        <option value="运营专员">运营专员</option>
                    </c:if>
                    <c:if test="${echo_Staff.position_name == '部门经理'}">
                        <option value="部门经理" selected="selected">部门经理</option>
                        <option value="助理" >助理</option>
                        <option value="会计师" >会计师</option>
                        <option value="程序员">程序员</option>
                        <option value="运营专员">运营专员</option>
                    </c:if>
                    <c:if test="${echo_Staff.position_name == '会计师'}">
                        <option value="部门经理" >部门经理</option>
                        <option value="助理" >助理</option>
                        <option value="会计师" selected="selected">会计师</option>
                        <option value="程序员">程序员</option>
                        <option value="运营专员">运营专员</option>
                    </c:if>
                    <c:if test="${echo_Staff.position_name == '程序员'}">
                        <option value="部门经理" >部门经理</option>
                        <option value="助理" >助理</option>
                        <option value="会计师" >会计师</option>
                        <option value="程序员" selected="selected">程序员</option>
                        <option value="运营专员">运营专员</option>
                    </c:if>
                    <c:if test="${echo_Staff.position_name == '运营专员'}">
                        <option value="部门经理" >部门经理</option>
                        <option value="助理" >助理</option>
                        <option value="会计师" >会计师</option>
                        <option value="程序员">程序员</option>
                        <option value="运营专员" selected="selected">运营专员</option>
                    </c:if>
                </select>
          </div>

            <div class="form-group">
                <label for="authority_type">权限：</label>
                <input type="text" class="form-control" id="authority_type" value="${echo_Staff.authority_type}" name="authority_type"  readonly="readonly" placeholder="" />
            </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                <input class="btn btn-default" type="button" onclick="re()" value="返回"/>
             </div>
        </form>
        </div>
    </body>
</html>