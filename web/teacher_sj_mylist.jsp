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
    <title>查看我任教的班级</title>
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

    <script src="javascripts/jquery-1.8.3.min.js"></script>
    <script src="javascripts/jquery.lwtCountdown-1.0.js"></script>

    <script src="js/ServerAddress.js"></script>
    <script src="js/teacherSjMylist.js"></script>
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
                        <li><i class="fa fa-table" aria-hidden="true"></i><a href="#">试卷管理</a></li>
                        <li><a href="teacher_sj_mylist.jsp">我的试卷</a></li>
                    </ul>
                </div>
            </div>
            <div class="row animated fadeInRight">
                <div class="col-sm-12">
                    <h4 class="section-subtitle"><b>我的所有试卷</b></h4>
                    <div class="panel">
                        <div class="panel-content">
                            <div class="table-responsive">
                                <table id="basic-table" class="data-table table table-striped nowrap table-hover" cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>试题名称</th>
                                        <th>试题标记</th>
                                        <th>试题备注</th>
                                        <th>题目数量</th>
                                        <th>课程章节</th>
                                        <th>答题人数</th>
                                        <th>正确率</th>
                                        <th>创建时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tbody">
                                    <%--<tr>--%>
                                        <%--<td>1</td>--%>
                                        <%--<td>分部积分求解练习</td>--%>
                                        <%--<td>分部积分</td>--%>
                                        <%--<td>使用分部积分法求得积分解</td>--%>
                                        <%--<td>12</td>--%>
                                        <%--<td>数学分析-ch5</td>--%>
                                        <%--<td>71&nbsp;&nbsp;<button type="button" class="btn btn-danger">谁未答题？</button></td><!-- 弹窗选择答题过的班级，通过校验码获取到未答题的学生 -->--%>
                                        <%--<td>75%</td>--%>
                                        <%--<td>2017-12-11</td>--%>
                                        <%--<td>--%>
                                            <%--<button type="button" class="btn btn-success">查看</button>--%>
                                            <%--<button type="button" class="btn btn-primary">修改</button>--%>
                                            <%--<button type="button" class="btn btn-danger">删除</button>--%>
                                        <%--</td>--%>
                                    <%--</tr>--%>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--row animated fadeInRight-->
        </div><!--content end-->



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
