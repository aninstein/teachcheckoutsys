<%@page import="com.aninstein.bean.TeachersPO"%>
<%@page import="com.aninstein.en.TeachersStatuEnum"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	//检查信息是否完整
	TeachersPO teachersPO=(TeachersPO)request.getSession().getAttribute("teacherInfo");
 %>

<!DOCTYPE HTML>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="apple-touch-icon" sizes="120x120"
	href="favicon/apple-icon-120x120.png">
<link rel="icon" type="image/png" sizes="192x192"
	href="favicon/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32"
	href="favicon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="16x16"
	href="favicon/favicon-16x16.png">
<link rel="stylesheet" type="text/css"
	href="stylesheets/css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="stylesheets/css/font-awesome.min.css">
<link rel="stylesheet" href="vendor/animate.css/animate.css">
<link rel="stylesheet" href="vendor/toastr/toastr.min.css">
<link rel="stylesheet" href="vendor/magnific-popup/magnific-popup.css">
<link rel="stylesheet" href="stylesheets/css/style.css">


<link rel="stylesheet" type="text/css"
	href="stylesheets/css/bootstrap-3.3.4.css">
<link href="stylesheets/css/style2.css" rel="stylesheet">
<link href="stylesheets/css/style3.css" rel="stylesheet">

<script src="javascripts/jquery-1.8.3.min.js"></script>
<script src="javascripts/jquery.lwtCountdown-1.0.js"></script>
</head>
<body>
	<div class="wrap">
		<div class="page-body">
		
		
		<!-- sidebar start -->
        <div class="left-sidebar">
            <div class="left-sidebar-header">
                <div class="left-sidebar-title">欢迎使用实时答题系统</div>
                <div class="left-sidebar-toggle c-hamburger c-hamburger--htla hidden-xs" data-toggle-class="left-sidebar-collapsed" data-target="html">
                    <span></span>
                </div>
            </div>
            <div id="left-nav" class="nano">
                <div class="nano-content">
                    <nav>
                        <ul class="nav" id="main-nav">
                            <li class="active-item"><a href="index.html"><i class="fa fa-home" aria-hidden="true"></i><span>首页</span></a></li>
                            <li class="has-child-item close-item">
                                <a><i class="fa fa-cubes" aria-hidden="true"></i><span>试卷管理</span></a>
                                <ul class="nav child-nav level-1">
                                    <li><a href="tables_data-Politics.html">添加试卷</a></li>
                                    <li><a href="tables_data-English.html">我的试卷</a></li>
                                    <li><a href="tables_data-Math.html">下载社区</a></li>
                                </ul>
                            </li>
                            
                            <li class="has-child-item close-item">
                                <a><i class="fa fa-table" aria-hidden="true"></i><span>学生管理</span></a>
                                <ul class="nav child-nav level-1">
                                    <li><a href="tables_basic.html">今日签到</a></li>                                          
                                    <li><a href="tables_data-tables.html">历史签到</a></li>
                                    <li><a href="tables_responsive.html">我的班级</a></li>
                                </ul>
                            </li>
                           <li class="has-child-item close-item">
                                <a><i class="fa fa-user-circle" aria-hidden="true"></i><span>我的信息</span></a>
                                <ul class="nav child-nav level-1">
                                   
                                    <li><a href="tables_data_myDoc.html">修改信息</a></li>
                                </ul>
                            </li>
                          
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        
        <!-- sidebar end -->
        </div><!-- page-body -->
	</div><!-- wrap -->

	<script src="javascripts/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="vendor/nano-scroller/nano-scroller.js"></script>
	<script src="javascripts/template-script.min.js"></script>
	<script src="javascripts/template-init.min.js"></script>
	<script src="vendor/toastr/toastr.min.js"></script>
	<script src="vendor/chart-js/chart.min.js"></script>
	<script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
	<script src="javascripts/examples/dashboard.js"></script>
</body>