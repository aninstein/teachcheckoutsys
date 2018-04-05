<%@ page import="com.aninstein.bean.TeachersPO" %>
<%@ page import="com.aninstein.en.TeachersStatuEnum" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/21
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

    //检查是否登陆
    if (request.getSession().getAttribute("username") == null || request.getSession().getAttribute("statu") == null || (int) request.getSession().getAttribute("statu") > TeachersStatuEnum.Admin.ordinal()) {
        request.getRequestDispatcher("teacher_login.jsp").forward(request, response);
    }

    //检查信息是否完整
    TeachersPO teachersPO = (TeachersPO) request.getSession().getAttribute("teacherInfo");
    String name = "信息未完善";
    String level = "";
    if (teachersPO.getTeachername() != null && teachersPO.getTeacherlevel() != null) {
        name = teachersPO.getTeachername();
        level = teachersPO.getTeacherlevel();
    }
%>

<!doctype html>
<html lang="en" class="fixed">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <title>编辑试卷</title>
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

    <link rel="stylesheet" href="css/upload.css">

    <script src="javascripts/jquery-1.8.3.min.js"></script>
    <script src="javascripts/jquery.lwtCountdown-1.0.js"></script>

    <script src="js/ServerAddress.js"></script>
    <script src="js/teachersj.js"></script>
    <script src="js/Sj.js"></script>
    <script src="js/Questions.js"></script>
    <script src="js/Alphabet.js"></script>
    <script src="layer/layer.js"></script>

</head>

<body>
<input type="hidden" id="abspath" value="${pageContext.request.contextPath}"/>
<input type="hidden" id="admin" value="<%=teachersPO.getTeacherstatu() %>"/>
<input type="hidden" id="teacherid" value="<%=teachersPO.getTeacherid() %>"/>
<input type="hidden" id="theteachername" value="<%=teachersPO.getTeachername() %>"/>

<div class="wrap">
    <%-- 导入网站头部 --%>
    <%-- 	<jsp:include page="teahcer_pageheader.jsp"></jsp:include> --%>
    <!-- header start -->
    <div class="page-header">
        <div class="leftside-header">
            <div class="logo">
                <a href="index.html" class="on-click"> <img alt="logo"
                                                            src="images/header-logo.png"/>
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
                        <img src="images/user-avatar.jpg" alt="<%=name %>"/>
                    </div>
                    <div class="user-info">
                        <span class="user-name" id="teachername"><%=name %></span>
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
                                </ul>
                            </li>

                            <li class="has-child-item close-item"><a><i
                                    class="fa fa-table" aria-hidden="true"></i><span>学生管理</span></a>
                                <ul class="nav child-nav level-1">
                                    <li><a href="tables_basic.html">今日签到</a></li>
                                    <li><a href="tables_data-tables.html">历史签到</a></li>
                                    <li><a href="teacher_myclass.jsp">我的班级</a></li>
                                </ul>
                            </li>
                            <li class="has-child-item close-item"><a><i
                                    class="fa fa-user-circle" aria-hidden="true"></i><span>我的信息</span></a>
                                <ul class="nav child-nav level-1">
                                    <li><a href="teacher_info.jsp">更改个人信息</a></li>
                                    <li><a href="teacher_changepwd.jsp">修改密码</a></li>
                                </ul>
                            </li>
                            <%
                                if (teachersPO.getTeacherstatu() == TeachersStatuEnum.Admin.ordinal()) {
                            %>
                            <li class="has-child-item close-item"><a><i
                                    class="fa fa-cog" aria-hidden="true"></i><span>管理员权限</span></a>
                                <ul class="nav child-nav level-1">
                                    <li><a href="admin_audit.jsp">审核申请</a></li>
                                    <li><a href="admin_teacher.jsp">教师管理</a></li>
                                    <li><a href="admin_course.jsp">课程管理</a></li>
                                    <li><a href="teacher_changepwd.jsp">文件管理</a></li>
                                    <li><a href="admin_student.jsp">学生管理</a></li>
                                </ul>
                            </li>
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
                        <li><i class="fa fa-columns" aria-hidden="true"></i><a href="#">试卷管理</a></li>
                        <li><a>编辑试卷</a></li>
                    </ul>
                </div>
            </div>


            <div class="row animated fadeInUp">
                <div class="col-sm-12 col-md-6">
                    <h4 class="section-subtitle"><b>编辑试卷请注意试卷答案正确性！</b></h4>
                    <div class="panel">
                        <div class="panel-content">
                            <div class="row">
                                <div class="col-md-12">
                                    <form class="form-horizontal">

                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="button" class="btn btn-darker-1 btn-block" id="confirmtest">完成试卷</button>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="sjname" class="col-sm-2 control-label">试题名称</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" placeholder="试题名称" id="sjname" required/>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="sjtag" class="col-sm-2 control-label">试题标签</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" placeholder="试题标记便于查找" id="sjtag" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="sjdecri" class="col-sm-2 control-label">试题描述</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" placeholder="试题描述本试题主要是那方面内容" id="sjdecri" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="sjsubject" class="col-sm-2 control-label">试题科目</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" placeholder="试题所属科目" id="sjsubject" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <label for="sjsubjectchp" class="col-sm-2 control-label">试题章节</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" placeholder="试题所属试题章节" id="sjsubjectchp" />
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="col-sm-6 col-md-4 col-lg-4">
                    <div class="panel widgetbox wbox-1 bg-darker-2 color-light">
                        <a href="#">
                            <div class="panel-content">
                                <h1 class="title color-light-1"><i class="fa fa-file"></i>&nbsp;&nbsp;<span id="questionnum">0</span></h1>
                                <h4 class="subtitle">本试卷共有试题</h4>
                            </div>
                        </a>
                    </div>
                </div>

                <div class="col-sm-4 col-lg-2">
                    <div class="panel widgetbox wbox-3 bg-warning">
                        <a href="javascript:void(0);" onclick="inputfile()">
                            <%--<input type="file" name="sjfile" id="sjfile1" >--%>
                            <div class="panel-content">
                                <span class="icon fa fa-plus"></span>
                                <h1 class="title">导入试卷</h1>
                                <h4 class="subtitle">Import Test</h4>
                            </div>
                        </a>
                    </div>
                </div>



                <div class="col-md-12">
                    <h4 class="section-subtitle"><b>试题内容</b></h4>

                    <div id="tectti"></div>
                </div>


                <div class="col-sm-4 col-lg-2">
                    <div class="panel widgetbox wbox-3 bg-success">
                        <a href="javascript:void(0);" onclick="addquestions()">
                            <div class="panel-content">
                                <span class="icon fa fa-plus"></span>
                                <h1 class="title">添加单选题目</h1>
                                <h4 class="subtitle">Add a Question</h4>
                            </div>
                        </a>
                    </div>
                </div>

            </div><!-- row animated fadeInUp -->
        </div><!-- content -->



    </div>
</div>

<script src="javascripts/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/nano-scroller/nano-scroller.js"></script>
<script src="javascripts/template-script.min.js"></script>
<script src="javascripts/template-init.min.js"></script>

<%
    if (teachersPO.getTeachername() == null) {
%>
<script type="text/javascript">
    alert("您的信息没有完善！请先完善信息！");
    location.href = "teacher_info_modify.jsp";
</script>
<%
        //request.getRequestDispatcher("teacher_info_modify.jsp").forward(request, response);
    }
%>

</body>

</html>
