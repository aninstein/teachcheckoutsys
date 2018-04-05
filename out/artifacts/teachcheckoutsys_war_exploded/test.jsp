<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/13
  Time: 0:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en" class="fixed accounts sign-in">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache, must-revalidate">
    <META HTTP-EQUIV="expires" CONTENT="0">

    <title>测试页面</title>
    <link rel="apple-touch-icon" sizes="120x120" href="favicon/apple-icon-120x120.png">
    <link rel="icon" type="image/png" sizes="192x192" href="favicon/android-icon-192x192.png">
    <link rel="icon" type="image/png" sizes="32x32" href="favicon/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="favicon/favicon-16x16.png">
    <link rel="stylesheet" type="text/css" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.6.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="vendor/animate.css/animate.css">
    <link rel="stylesheet" href="stylesheets/css/style.css">

    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>

</head>

<body>
<input type="hidden" id="abspath" value="${pageContext.request.contextPath}" />
<%--<form action="${pageContext.request.contextPath}/UploadFileServlet" enctype="multipart/form-data" method="post">--%>
    <%--上传文件类型：<input type="text" name="path" value="student" /><br>--%>
    <%--上传用户：<input type="text" name="username"><br/>--%>
    <%--上传文件1：<input type="file" name="file1"><br/>--%>
    <%--上传文件2：<input type="file" name="file2"><br/>--%>
    <%--<input type="submit" value="提交">--%>
<%--</form>--%>

<form class="form-inline" action="/teachcheckoutsys/UploadFileServlet" enctype="multipart/form-data" method="post"
      id="fromStudent"></form>

</body>

</html>

