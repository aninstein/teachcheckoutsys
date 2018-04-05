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

<input type="hidden" id="abspath" value="${pageContext.request.contextPath}" />

	<div class="wrap">
	
		<!-- header start -->
		<div class="page-header">
			<div class="leftside-header">
				<div class="logo">
					<a href="index.html" class="on-click"> <img alt="logo"
						src="images/header-logo.png" />
					</a>
				</div>
				<div id="menu-toggle" class="visible-xs toggle-left-sidebar"
					data-toggle-class="left-sidebar-open" data-target="html">
					<i class="fa fa-bars" aria-label="Toggle sidebar"></i>
				</div>
			</div>
			<div class="rightside-header">
				<div class="header-middle"></div>

				<div class="header-section" id="user-headerbox">
					<div class="user-header-wrap">
						<div class="user-photo">
							<!-- 头像    -->
							<img src="images/user-avatar.jpg" alt="Jane Doe" />
						</div>
						<div class="user-info">
							<span class="user-name"><%=teachersPO.getTeachername() %></span> 
							<span class="user-profile"><%=teachersPO.getTeacherlevel() %>,您好！</span>
						</div>
						<i class="fa fa-plus icon-open" aria-hidden="true"></i> <i
							class="fa fa-minus icon-close" aria-hidden="true"></i>
					</div>
					<div class="user-options dropdown-box">
						<div class="drop-content basic">
							<ul>
								<li><a href="teacher_info.jsp"><i
										class="fa fa-user" aria-hidden="true"></i> 个人资料</a></li>
								<li><a href="teacher_changepwd.jsp"><i
										class="fa fa-lock" aria-hidden="true"></i> 修改密码</a></li>
								<li><a href="${pageContext.request.contextPath}/TeachersLogoutServlet"><i class="fa fa-cog"
										aria-hidden="true"></i>注销登录</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="header-separator"></div>
				<div class="header-section">
					<a href="${pageContext.request.contextPath}/TeachersLogoutServlet"><i class="fa fa-sign-out log-out"
						aria-hidden="true" title="注销登录">退出登录</i></a>
				</div>
			</div>
		</div>
		
		<!-- haeder end -->
		
	</div>

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