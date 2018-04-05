<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en" class="fixed accounts sign-in">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>注册账号</title>
    <link rel="apple-touch-icon" sizes="120x120" href="favicon/apple-icon-120x120.png">
    <link rel="icon" type="image/png" sizes="192x192" href="favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon/favicon-16x16.png">
    <link rel="stylesheet" href="vendor/animate.css/animate.css">
    <link rel="stylesheet" href="stylesheets/css/style.css">
    <link rel="stylesheet" type="text/css" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css">
   
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/ServerAddress.js"></script>
    <script type="text/javascript" src="js/teacherSign.js"></script>
    
</head>

<body>
<input type="hidden" id="abspath" value="${pageContext.request.contextPath}" />


<div class="wrap">
    <div class="page-body animated slideInDown">
        <div class="logo">
            <%--<img alt="logo" src="images/logo-dark.png"/>--%>
            <h1 style="margin:1em 3.5em;font-family: 'Microsoft YaHei';color:#000;"><strong>&nbsp;教师注册</strong></h1>
        </div>
        <div class="box">
            <div class="panel mb-none">
                <div class="panel-content bg-scale-0">
                    <form>
                    	<div class="form-group mt-md">
                            <span class="input-with-icon">
                                    <input type="text" class="form-control" id="teacherId" name="teacherId" placeholder="请输入教师证号码">
                                    <i class="fa fa-id-card" aria-hidden="true"></i>
                            </span>
                        </div>
                        <div class="form-group mt-md">
                            <span class="input-with-icon">
                                    <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
                                    <i class="fa fa-user"></i>
                            </span>
                        </div>
						<div class="form-group mt-md">
                            <span class="input-with-icon">
                                    <input type="email" class="form-control" id="email" placeholder="请输入Email">
                                    <i class="fa fa-envelope"></i>
                            </span>
                        </div>
                        <div class="form-group">
                                <span class="input-with-icon">
                                        <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                                        <i class="fa fa-key"></i>
                                    </span>
                        </div>
						<div class="form-group">
                                <span class="input-with-icon">
                                        <input type="password" class="form-control" id="repassword" name="password" placeholder="再次确认密码" >
                                        <i class="fa fa-key"></i>
                                    </span>
                        </div>
                        
                        <div class="form-group">
                        	<input type="button" id="ip_sign" class="btn btn-primary btn-block" value="注册" />
                        </div>
						<div class="form-group">
                            <a href="teacher_login.jsp" class="btn btn-primary btn-block">返回登录</a>
                        </div>
                        <div class="form-group text-center">
                            <a href="#">点击查看《师生课上答题及时反馈系统使用规章条例》</a>
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
