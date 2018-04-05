<%@ page import="com.aninstein.en.TeachersStatuEnum" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/13
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //检查是否登陆
    if(request.getSession().getAttribute("username")==null
            ||request.getSession().getAttribute("statu")==null
            ||(int)request.getSession().getAttribute("statu") > TeachersStatuEnum.Admin.ordinal()){
        request.getRequestDispatcher("teacher_login.jsp").forward(request, response);
    }
%>


<!doctype html>
<html lang="en" class="fixed accounts sign-in">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <META HTTP-EQUIV="expires" CONTENT="0">

    <title>修改密码</title>
    <link rel="apple-touch-icon" sizes="120x120" href="favicon/apple-icon-120x120.png">
    <link rel="icon" type="image/png" sizes="192x192" href="favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon/favicon-16x16.png">
    <link rel="stylesheet" type="text/css" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="vendor/animate.css/animate.css">
    <link rel="stylesheet" href="stylesheets/css/style.css">

    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/ServerAddress.js"></script>
    <script type="text/javascript" src="js/teacherChangePwd.js"></script>


</head>

<body>
<input type="hidden" id="abspath" value="${pageContext.request.contextPath}" />

<div class="wrap">
    <div class="page-body animated slideInDown">
        <div class="logo">
            <%--<img alt="logo" src="images/logo-dark.png"/>--%>
            <h1 style="margin:1em 3.5em;font-family: 'Microsoft YaHei';color:#000;"><strong>&nbsp;修改密码</strong></h1>
        </div>
        <div class="box">
            <div class="panel mb-none">
                <div class="panel-content bg-scale-0">
                    <form action="${pageContext.request.contextPath}/TeachersLoginServlet" method="post">
                        <div class="form-group">
                            <span class="input-with-icon">
                                <input type="password" class="form-control" id="org_password" name="password" placeholder="请输入原密码">
                                <i class="fa fa-key"></i>
                            </span>
                        </div>
                        <div class="form-group">
                            <span class="input-with-icon">
                                <input type="password" class="form-control" id="new_password" name="password" placeholder="请输入6位新密码字母、数字组合">
                                <i class="fa fa-key"></i>
                            </span>
                        </div>
                        <div class="form-group">
                            <span class="input-with-icon">
                                <input type="password" class="form-control" id="renew_password" name="password" placeholder="两次密码必须一致">
                                <i class="fa fa-key"></i>
                            </span>
                        </div>
                        <div class="form-group">
                            <input class="btn btn-primary btn-block" type="button" id="ip_confirm_btn" value="确认修改"/>
                            <input class="btn btn-primary btn-block" type="button" id="ip_cancel_btn" value="取消"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/nano-scroller/nano-scroller.js"></script>
<script src="javascripts/template-script.min.js"></script>
<script src="javascripts/template-init.min.js"></script>
</body>

</html>

