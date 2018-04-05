<%@page import="com.aninstein.bean.TeachersPO"%>
<%@page import="com.aninstein.en.TeachersStatuEnum"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%

	//检查是否登陆
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
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<title>师生课上实时答题系统</title>
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

	<input type="hidden" id="abspath"
		value="${pageContext.request.contextPath}" />

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
							<img src="images/user-avatar.jpg" alt="<%=name %>" />
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
							<li><i class="fa fa-home" aria-hidden="true"></i><a href="teacher_index.jsp">首页</a></li>
						</ul>
					</div>
				</div>
				<div class="row animated fadeInUp">
					<div class="col-sm-12 col-lg-9">
						<div class="row">
							<div class="col-sm-12 col-md-4">
								<div class="panel widgetbox wbox-2 bg-scale-0">
									<a href="#">
										<div class="panel-content">
											<div class="row">
												<div class="col-xs-4">
													<span class="icon fa fa-file color-darker-1"></span>
												</div>
												<div class="col-xs-8">
													<h4 class="subtitle color-darker-1">本站共发布试卷</h4>
													<h1 class="title color-primary">27</h1>
												</div>
											</div>
										</div>
									</a>
								</div>
								<div class="panel widgetbox wbox-2 bg-lighter-2 color-light">
									<a href="#">
										<div class="panel-content">
											<div class="row">
												<div class="col-xs-4">
													<span class="icon fa fa-file color-darker-2"></span>
												</div>
												<div class="col-xs-8">
													<h4 class="subtitle color-darker-2">个人发布试卷总数</h4>
													<h1 class="title color-w">3</h1>
												</div>
											</div>
										</div>
									</a>
								</div>
							</div>

							<h1 style="font-family:'Microsoft YaHei'; color:#000;font-size:4em;">
								<strong>欢迎使用师生课上实时答题系统！</strong>
								</h1></div>
					</div>
				</div>
				<div class="col-sm-12 col-lg-3">
					<div class="timeline">
						<div class="timeline-box">
							<div class="timeline-icon bg-primary">
								<i class="fa fa-check"></i>
							</div>
							<div class="timeline-content">
								<h4 class="tl-title">创建试卷</h4>
								可以根据讲课内容动态的创建试卷，然后再让学生现场通过手机做题，可以快速的知道学生对课堂知识的掌握情况。
							</div>
							<div class="timeline-footer">
								<span>内容动态！</span>
							</div>
						</div>
						<div class="timeline-box">
							<div class="timeline-icon bg-primary">
								<i class="fa fa-check"></i>
							</div>
							<div class="timeline-content">
								<h4 class="tl-title">发布试卷</h4>
								学生端和教师端分开，老师可以在备课时候早就提前做好试卷，也可以从社区下载试卷模板导入，非常方便。
							</div>
							<div class="timeline-footer">
								<span>发布方便！</span>
							</div>
						</div>
						<div class="timeline-box">
							<div class="timeline-icon bg-primary">
								<i class="fa fa-check"></i>
							</div>
							<div class="timeline-content">
								<h4 class="tl-title">学生答题</h4>
								学生现场答题，答题后的数据实时的传递给老师，老师可以快速的了解到学生对课堂知识的掌握情况，还可以通过答题学生知道缺勤人数。
							</div>
							<div class="timeline-footer">
								<span>反馈及时！</span>
							</div>
						</div>
						<div class="timeline-box">
							<div class="timeline-icon bg-primary">
								<i class="fa fa-check"></i>
							</div>
							<div class="timeline-content">
								<h4 class="tl-title">试卷共享</h4>
								不是所有的试卷都只能自己做，我们提供了导出和导入试卷的功能，只要导出和导入试卷就可以重复的利用，也可以用别人做好的。甚至以后的书籍可以配套电子课堂练习。
							</div>
							<div class="timeline-footer">
								<span>数据共享！</span>
							</div>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-12 col-md-4">
						<div class="col-sm-12 col-lg-12">
							<h1>
								<strong
									style="font-family: 'Microsoft YaHei'; font-size:1em; margin:0 auto;">资讯快报</strong>
								</h1>
						</div>
						<div class="panel b-primary bt-md">
							<div class="panel-content p-none">
								<div class="widget-list list-to-do">
									<h4 class="list-title">教学信息快报</h4>
									<!--<button class="add-item btn btn-o btn-primary btn-xs"><i class="fa fa-plus"></i></button>-->
									<ul>
										<li>
											<div class="checkbox-custom checkbox-primary">
												<input type="checkbox" id="check-h1" value="option1">
												<label for="check-h1"><a
													href="https://www.zhihu.com/question/22876444"
													target='_blank'>怎么让学生爱上学习？</a></label>
											</div>
										</li>
										<li>
											<div class="checkbox-custom checkbox-primary">
												<input type="checkbox" id="check-h2" value="option1" checked>
												<label for="check-h3"><a
													href="http://www.liuxue86.com/a/2977151.html"
													target='_blank'>中国科学院造出世界上第一台光量子计算机</a></label>
											</div>
										</li>
										<li>
											<div class="checkbox-custom checkbox-primary">
												<input type="checkbox" id="check-h3" value="option1">
												<label for="check-h2"><a
													href="http://yjs.tjut.edu.cn/" target='_blank'>天津理工大学研究生院通知</a></label>
											</div>
										</li>
										<li>
											<div class="checkbox-custom checkbox-primary">
												<input type="checkbox" id="check-h4" value="option1">
												<label for="check-h4"><a
													href="https://wenku.baidu.com/view/cee77c7ba55177232f60ddccda38376baf1fe08e.html"
													target='_blank'>大学的数学深么？</a></label>
											</div>
										</li>
										<li>
											<div class="checkbox-custom checkbox-primary">
												<input type="checkbox" id="check-h5" value="option1">
												<label for="check-h5"><a
													href="http://kaoyan.eol.cn/fu_xi/zhinan/201701/t20170109_1482182.shtml"
													target='_blank'>2017年高等院校教师平均薪资地区排行</a></label>
											</div>
										</li>
										<li>
											<div class="checkbox-custom checkbox-primary">
												<input type="checkbox" id="check-h6" value="option1">
												<label for="check-h6"> <a
													href="http://www.chinakaoyan.com/info/article/id/159615.shtml"
													target='_blank'>怎么让学生意识到要趁年轻多学点东西？</a>
												</label>
											</div>
										</li>
									</ul>
								</div>

							</div>
						</div>
					</div>

				</div>
			</div>
			<!--content end-->
		</div>
		<!-- page-body -->
	</div>
	<!-- warp -->

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

<%
	if(teachersPO.getTeachername()==null){
		%>
		<script type="text/javascript">
			alert("您的信息没有完善！请先完善信息！");
			location.href="teacher_info_modify.jsp";
		</script>
		<% 
		//request.getRequestDispatcher("teacher_info_modify.jsp").forward(request, response);
	}
 %>

</html>
