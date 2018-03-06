<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.user.UserInfoBean" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/lendInfo/main.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>读者详情</title>
</head>
<body>
<table class="libtypeContent" style="width:500px;">
<%  Object userInfo0=request.getAttribute("userInfo");
    UserInfoBean userInfo=(UserInfoBean)userInfo0;%>
<tr><td>用户名</td><td><%= userInfo.getUserName() %></td></tr>
<tr><td>性别</td><td><%= userInfo.getSex() %></td></tr>
<tr><td>简介</td><td><%= userInfo.getRemark() %></td></tr>
<tr><td>证件类型</td><td><%= userInfo.getPapertype() %></td></tr>
<tr><td>证件号码</td><td><%= userInfo.getPaperNO() %></td></tr>
<tr><td>生日</td><td><%= userInfo.getBirthday() %></td></tr>
<tr><td>邮箱</td><td><%= userInfo.getEmail() %></td></tr>
<tr><td>注册时间</td><td><%= userInfo.getRegeditTime() %></td></tr>
<tr><td>手机号码</td><td><%= userInfo.getTel() %></td></tr>
</table>
</body>
</html>