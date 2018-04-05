<%@page import="com.aninstein.bean.TeachersPO"%>
<%@page import="com.aninstein.en.TeachersStatuEnum"%>
<%@ page language="java" pageEncoding="utf-8"%>
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
    }else if((int)request.getSession().getAttribute("statu") != TeachersStatuEnum.Admin.ordinal()){//管理员才能访问的页面
        request.getRequestDispatcher("teacher_index.jsp").forward(request, response);
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
    <title>课程管理</title>
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
    <script src="js/adminCourse.js"></script>
    <script src="layer/layer.js"></script>

</head>

<body>

<input type="hidden" id="abspath" value="${pageContext.request.contextPath}" />
<input type="hidden" id="admin" value="<%=teachersPO.getTeacherstatu() %>" />
<input type="hidden" id="teacherid" value="<%=teachersPO.getTeacherid() %>" />
<input type="hidden" id="teachername" value="<%=teachersPO.getTeachername() %>" />

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
                        <li><i class="fa fa-table" aria-hidden="true"></i><a href="teacher_index.jsp">主页</a></li>
                        <li><a>管理员权限</a></li>
                        <li><a href="admin_course.jsp">课程管理</a></li>
                    </ul>
                </div>
            </div>
            <div class="row animated fadeInRight">
                <div class="col-sm-12">
                    <h4 class="section-subtitle"><b>您可以通过导入Excel文件导入课程</b>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="https://teach-checkout.oss-cn-beijing.aliyuncs.com/teacher/teachsys/upload/教师表模板.xls">
                            点击下载“课程表模板.Excel”模板</a></h4>
                    <button class="btn btn-primary btn-wide" id="addstufile">导入课程</button>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <button class="btn btn-primary btn-wide" id="addstu">添加课程</button>

                    <div id="addspace">


                        <div class="panel" id="fileupload">
                            <div class="panel-content">
                                <div class="row">
                                    <div class="col-md-12">
                                        <form class="form-inline"  enctype="multipart/form-data"  method="post" id="dataForm">
                                            <h5 class="mb-lg ">课程表导入</h5>
                                            <input type="hidden" id="serviceName" name="serviceName" value="course" /><!-- 告诉后台我这是什么文件类型 -->
                                            <input type="hidden" id="path" name="path" value="teachsys/upload" /><!-- 给后台传递确认导入信号 -->
                                            <input type="hidden" id="fileName" name="fileName" value="课程表模板" /><!-- 告诉后台我这是什么文件类型 -->
                                            <input type="hidden" id="ext" name="ext" value="xls" /><!-- 给后台传递确认导入信号 -->
                                            <div class="form-group">
                             <span>
        						<a class="btn btn-wide btn-o btn-success btn-lg" id="afile" href="javascript:void(0);">选择文件
                                <input type="file" name="file1" id="file1" /></a>
        					</span>
                                            </div>
                                            <div class="form-group">
                                                <span id="spanFile">·只能上传后缀名为.xls、.xlsx文件</span>
                                            </div>
                                            <br><br>
                                            <div class="form-group">
                                                <input type="button" class="btn btn-wide btn-primary" onclick="uploadTable()" value="确认导入"/>
                                                <input type="button" class="btn btn-wide btn-warning" onclick="resetfile()" value="重新选择"/>
                                                <input type="button" class="btn btn-wide" name="add_cancel" value="取消"/>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="panel" id="classadd">
                            <div class="panel-content">
                                <div class="row">
                                    <div class="col-md-12">
                                        <form class="form-inline" id="addfrom"><h5 class="mb-lg ">请输入课程信息</h5>
                                            <div class="form-group">
                                                <span>课程号:<input type="text" class="form-control" id="courseid" name="courseid" placeholder="课程号"></span></div>&nbsp;&nbsp;
                                            <div class="form-group">
                                                <span>课程名:<input type="text" class="form-control" id="name" name="name" placeholder="课程名"></span></div>&nbsp;&nbsp;
                                            <div class="form-group">
                                 <span>需修专业:<input type="text" class="form-control" id="major" name="major" placeholder="需修专业" />注意：请用","号隔开！
        						 <span id="needmajor">
        						 </span>
        						 </span></div>&nbsp;&nbsp;
                                            <br><br>
                                            <div class="form-group">
                                                <span>学分:<input type="number" class="form-control" id="grade" name="grade" value=3.0 step=0.1 placeholder="学分"></span></div>&nbsp;&nbsp;
                                            <div class="form-group">
                                                <span>任教老师:<input type="text" class="form-control" id="teacher" name="teacher" placeholder="任教老师"></span></div>&nbsp;&nbsp;
                                            <div class="form-group">
                                                <span>开班人数:<input type="number" class="form-control" id="stunum" name="stunum" value=50 step=1 placeholder="开班人数"></span></div>&nbsp;&nbsp;
                                            <div class="form-group">
                                                <span>上课地点:<input type="text" class="form-control" name="location" id="location" placeholder="上课地点"></span></div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <br><br>
                                            <div class="form-group">上课时间：
                                                <span id="classtime">
        								<span id="oneclass">1、
        								<select class="form-control" name="classweekday">
        									<option value="1">星期一</option>
        									<option value="2">星期二</option>
        									<option value="3">星期三</option>
        									<option value="4">星期四</option>
        									<option value="5">星期五</option>
        									<option value="6">星期六</option>
        									<option value="7">星期日</option>
        								</select>
        								<select class="form-control" name="classtno">
        									<option selected="selected" value="1、2节">1、2节</option>
        									<option value="3、4节">3、4节</option>
        									<option value="5、6节">5、6节</option>
        									<option value="7、8节">7、8节</option>
        									<option value="10节">10节</option>
        									<option value="11节">11节</option>
        									<option value="12节">12节</option>
        								</select>
        								</span>
        							</span>
                                                <button type="button" id="addclasstimebtn" class="btn btn-o btn-success" title="添加一个上课时间">+</button>
                                                <button type="button" id="subclasstimebtn" class="btn btn-o btn-danger" title="减掉一个上课时间">&nbsp;-&nbsp;</button>
                                            </div>
                                            <br><br>
                                            <div class="form-group">
                                                <input type="button" class="btn btn-wide btn-primary" id="add_btn" value="添加"/>
                                                <input type="button" class="btn btn-wide" name="add_cancel" value="取消"/>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="panel">
                        <div class="panel-content">
                            <div class="row">
                                <div class="col-md-12">
                                    <form class="form-inline">
                                        <div class="form-group">
                                            <span class="input-with-icon">
                                                <input type="text" class="form-control" id="mysearch" name="mysearch" onblur="searchThis()" placeholder="请输入需要搜索的内容" />
                                                <i class="fa fa-search" aria-hidden="true"></i>
                                            </span>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table id="basic-table" class="data-table table table-striped nowrap table-hover" cellspacing="0" width="100%">
                                    <thead>
                                    <tr>
                                        <th id="checkboxcol"></th>
                                        <th>序号</th>
                                        <th>课程号</th>
                                        <th>课程名</th>
                                        <th>需修专业</th>
                                        <th>学分</th>
                                        <th>任教老师</th>
                                        <th>开班人数</th>
                                        <th>上课地点</th>
                                        <th>上课日</th>
                                        <th>上课时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="tbody"></tbody>
                                </table>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
        <!--content end-->
        <a href="#" class="scroll-to-top"><i class="fa fa-angle-double-up"></i></a>

    </div><!-- page-body -->
</div><!-- wrap -->
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/nano-scroller/nano-scroller.js"></script>
<script src="javascripts/template-script.min.js"></script>
<script src="javascripts/template-init.min.js"></script>

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
