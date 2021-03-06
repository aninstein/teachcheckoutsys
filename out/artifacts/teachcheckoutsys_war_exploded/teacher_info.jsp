<%@page import="com.aninstein.bean.TeachersPO"%>
<%@page import="com.aninstein.en.TeachersStatuEnum"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	if(request.getSession().getAttribute("username")==null
	||request.getSession().getAttribute("statu")==null
	||(int)request.getSession().getAttribute("statu") > TeachersStatuEnum.Admin.ordinal()){
		request.getRequestDispatcher("teacher_login.jsp").forward(request, response);
	}

	//检查信息是否完整
	TeachersPO teachersPO=(TeachersPO)request.getSession().getAttribute("teacherInfo");
	String name="信息未完善";
	String level="";
	if(teachersPO.getTeachername()!=null&&teachersPO.getTeacherlevel()!=null){
		name=teachersPO.getTeachername();
		level=teachersPO.getTeacherlevel();
	}
 %>

<!doctype html>
<html lang="en" class="fixed">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>我的信息</title>
    <link rel="apple-touch-icon" sizes="120x120" href="favicon/apple-icon-120x120.png">
    <link rel="icon" type="image/png" sizes="192x192" href="favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon/favicon-16x16.png">
    <link rel="stylesheet" type="text/css" href="stylesheets/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/css/font-awesome.min.css">
    <link rel="stylesheet" href="vendor/animate.css/animate.css">
    <link rel="stylesheet" href="vendor/toastr/toastr.min.css">
    <link rel="stylesheet" href="vendor/magnific-popup/magnific-popup.css">
    <link rel="stylesheet" href="stylesheets/css/style.css">
	
	
	<link rel="stylesheet" type="text/css" href="stylesheets/css/bootstrap-3.3.4.css">
	<link href="stylesheets/css/style2.css" rel="stylesheet">
	<link href="stylesheets/css/style3.css" rel="stylesheet">

	<script src="javascripts/jquery-1.8.3.min.js"></script>    
	<script src="javascripts/jquery.lwtCountdown-1.0.js"></script> 
	
	<!-- <style> -->
		<!-- .weiqiandao{color:red;} -->
	<!-- </style> -->
</head>

<body>
<div class="wrap">
		<%-- 导入网站头部 --%>
		<%-- 	<jsp:include page="teahcer_pageheader.jsp"></jsp:include> --%>
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
							<span class="user-name"><%=name %></span>
							<span class="user-profile"><%=level %></span>
						</div>
						<i class="fa fa-plus icon-open" aria-hidden="true"></i> <i
							class="fa fa-minus icon-close" aria-hidden="true"></i>
					</div>
					<div class="user-options dropdown-box">
						<div class="drop-content basic">
							<ul>
								<li><a href="teacher_info.jsp"><i class="fa fa-user"
										aria-hidden="true"></i> 个人资料</a></li>
								<li><a href="teacher_changepwd.jsp"><i
										class="fa fa-lock" aria-hidden="true"></i> 修改密码</a></li>
								<li><a
									href="${pageContext.request.contextPath}/TeachersLogoutServlet"><i
										class="fa fa-cog" aria-hidden="true"></i>注销登录</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="header-separator"></div>
				<div class="header-section">
					<a href="${pageContext.request.contextPath}/TeachersLogoutServlet"><i
						class="fa fa-sign-out log-out" aria-hidden="true" title="注销登录">退出登录</i></a>
				</div>
			</div>
		</div>

		<!-- haeder end -->

			<%-- 导入网站菜单 --%>
			<%-- 	<jsp:include page="teacher_pagesidebar.jsp"></jsp:include> --%>
			<div class="page-body">
				<!-- sidebar start -->
				<div class="left-sidebar">
					<div class="left-sidebar-header">
						<div class="left-sidebar-title">欢迎使用实时答题系统</div>
						<div
								class="left-sidebar-toggle c-hamburger c-hamburger--htla hidden-xs"
								data-toggle-class="left-sidebar-collapsed" data-target="html">
							<span></span>
						</div>
					</div>
					<div id="left-nav" class="nano">
						<div class="nano-content">
							<nav>
								<ul class="nav" id="main-nav">
									<li class="active-item"><a href="teacher_index.jsp"><i
											class="fa fa-home" aria-hidden="true"></i><span>首页</span></a></li>
									<li class="has-child-item close-item"><a><i
											class="fa fa-cubes" aria-hidden="true"></i><span>试卷管理</span></a>
										<ul class="nav child-nav level-1">
											<li><a href="teacher_sj.jsp">添加试卷</a></li>
											<li><a href="teacher_sj_mylist.jsp">我的试卷</a></li>
											<li><a href="tables_data-Math.html">下载社区</a></li>
										</ul></li>

									<li class="has-child-item close-item"><a><i
											class="fa fa-table" aria-hidden="true"></i><span>学生管理</span></a>
										<ul class="nav child-nav level-1">
											<li><a href="tables_basic.html">今日签到</a></li>
											<li><a href="tables_data-tables.html">历史签到</a></li>
											<li><a href="teacher_myclass.jsp">我的班级</a></li>
										</ul></li>
									<li class="has-child-item close-item"><a><i
											class="fa fa-user-circle" aria-hidden="true"></i><span>我的信息</span></a>
										<ul class="nav child-nav level-1">
											<li><a href="teacher_info.jsp">更改个人信息</a></li>
											<li><a href="teacher_changepwd.jsp">修改密码</a></li>
										</ul></li>
									<%
										if(teachersPO.getTeacherstatu()==TeachersStatuEnum.Admin.ordinal()){
									%>
									<li class="has-child-item close-item"><a><i
											class="fa fa-cog" aria-hidden="true"></i><span>管理员权限</span></a>
										<ul class="nav child-nav level-1">
											<li><a href="admin_audit.jsp">审核申请</a></li>
											<li><a href="admin_teacher.jsp">教师管理</a></li>
											<li><a href="admin_course.jsp">课程管理</a></li>
											<li><a href="teacher_changepwd.jsp">文件管理</a></li>
											<li><a href="admin_student.jsp">学生管理</a></li>
										</ul></li>
									<%
										}
									%>

								</ul>
							</nav>
						</div>
					</div>
				</div>

				<!-- sidebar end -->

		
		
		<!--content start-->
        <div class="content">
            <div class="content-header">
                <div class="leftside-content-header">
                    <ul class="breadcrumbs">
                        <li><i class="fa fa-copy" aria-hidden="true"></i><a href="teacher_index.jsp">主页</a></li>
                        <li><a href="teacher_info.jsp">我的信息</a></li>
                    </ul>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 col-lg-4">
                    <div>
                        <div class="profile-photo">
                            <img alt="<%=name %>" src="images/user-avatar.jpg" />
							<span>暂时还无法更换头像！</span>
                        </div>
                        <div class="user-header-info">
							<a class="btn btn-wide btn-primary" href="teacher_info_modify.jsp">修改信息</a>
                            <h2 class="user-name"><%=name %></h2>
                            
                        </div>
                    </div>
                    <div class="panel bg-scale-0 b-primary bt-sm mt-xl">
                        <div class="panel-content">
                            <h4 class=""><b>我的基本信息</b></h4>
                            <ul class="user-contact-info ph-sm">
                            	<li><b><i class="color-primary mr-sm fa fa-black-tie"></i></b>职称：<%=teachersPO.getTeacherlevel() %></li>
                            	<li><b><i class="color-primary mr-sm fa fa-user"></i></b>用户名：<%=teachersPO.getTeacherusername() %></li>
                                <li><b><i class="color-primary mr-sm fa fa-envelope"></i></b>邮箱：<%=teachersPO.getTeacheremail() %></li>
                                <li><b><i class="color-primary mr-sm fa fa-phone"></i></b>电话：<%=teachersPO.getTeachertel() %></li>
                                <li><b><i class="color-primary mr-sm fa fa-file"></i></b>我的发布试题数目：<%=teachersPO.getTeachtinumber() %></li>
								<li><b><i class="color-primary mr-sm fa fa-file"></i></b>我的上传文件数目：<%=teachersPO.getTeachfilenumber() %></li>
                                <li class="mt-sm">我任教的课程：
                                <%
											if(teachersPO.getTeachercourse()!=null){
												List<String> courseList=teachersPO.getTeachercourse();
												for(String course:courseList){
													%>
													<button class="btn btn-wide btn-primary btn-xs"><%=course %></button>
													<% 
												}
											}
										 %>
									</li>
                            </ul>
                        </div>
                    </div>
                    <div class="panel  b-primary bt-sm ">
                        <div class="panel-content">
                            <div class="widget-list list-sm list-left-element ">
                                <ul>
								
                                    <li>
                                        <a href="#">
                                            <div class="left-element"><i class="fa fa-users" aria-hidden="true"></i></div>
                                            <div class="text">
                                                <span class="title">14计科1班</span>
                                                <span class="subtitle">38人</span>
                                            </div>
                                        </a>
                                    </li>
									
                                    <li>
                                        <a href="#">
                                            <div class="left-element"><i class="fa fa-users" aria-hidden="true"></i></div>
                                            <div class="text">
                                                <span class="title">14计科2班</span>
                                                <span class="subtitle">37人</span>
                                            </div>
                                        </a>
                                    </li>
									
                                </ul>
								
								
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        


        <a href="#" class="scroll-to-top"><i class="fa fa-angle-double-up"></i></a>
    </div>
</div>
<script src="javascripts/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/nano-scroller/nano-scroller.js"></script>
<script src="javascripts/template-script.min.js"></script>
<script src="javascripts/template-init.min.js"></script>
<script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
<script>
    //MAGNIFIC POPUP GALLERY
    $(function() {
        $('.gallery-wrap').magnificPopup({
            delegate: 'a',
            type: 'image',
            gallery: {
                enabled: true,
                navigateByImgClick: true,
                preload: [0, 1]
            },
            tLoading: 'Loading image #%curr%...',
            mainClass: 'mfp-no-margins mfp-with-zoom',
            zoom: {
                enabled: true,
                duration: 300
            }
        });
    });
</script>
</body>

</html>
