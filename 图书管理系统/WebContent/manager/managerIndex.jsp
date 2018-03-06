<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.aboutlib.LibraryBean" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/manager/manager.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/manager/layout.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/manager/style.css"/>
<title>图书馆信息</title>
</head>
<body>

<div class="container">
<div class="header"><img src="<%=request.getContextPath()%>/images/image2.jpg" alt="欢迎来到图书管理系统"/></div>
<div class="adminer">
<span style="font-size:30px;position:relative;left:850px;">
<% 
String user=(String)session.getAttribute("user");
if(user==null){
%>
<a href="<%=request.getContextPath()%>/manager/login.jsp" >登录</a>
<% }else{ %>
欢迎光临,<%=user %>
<% } %>
</span>
</div>

<div class="clearfloat"></div>
<div style="height=50px;line-height:50px;font-size:25px;position:relative;left:700px;">
<a href="<%= request.getContextPath()%>/manager/managerIndex.jsp">&gt;图书馆信息</a>
<a href="<%=request.getContextPath()%>/QueryBookServlet?libtype=0&libname=">&gt;图书信息</a>
<a href="<%= request.getContextPath()%>/manager/addLib.jsp">&gt;添加图书</a>
</div>
<div class="main">
<% LibraryBean library=(LibraryBean)session.getAttribute("library"); %>
<form action="<%=request.getContextPath()%>/LibraryServlet" method="post">
<table class="library">
<tr>
<td>图书馆名字:</td>
<td class="name"><input type="text" class="item" disabled="disabled" name="name" id="name" value=<%= library.getName() %>></td></tr>

<tr>
<td>建馆时间:</td>
<td  class="buildTime"><input type="text" class="item" disabled="disabled" name="buildTime" id="buildTime" value=<%= library.getBuildTime() %>></td></tr>

<tr>
<td>图书馆网站:</td>
<td class="libWebsite"><input type="text" class="item" disabled="disabled" name="libWebsite" id="libWebsite" value=<%= library.getLibWebsite() %>></td></tr>

<tr>
<td>工作日:</td>
<td class="weekday"><input type="text" class="item1" disabled="disabled" name="openTimeOnWeekday" id="openTimeOnWeekday" value=<%= library.getOpenTimeOnWeekday() %>>——<input class="item1" type="text" disabled="disabled" name="endTimeOnWeekday" id="endTimeOnWeekday" value=<%= library.getEndTimeOnWeekday() %>></td></tr>

<tr>
<td>休息日:</td>
<td class="weekend"><input type="text" class="item1" disabled="disabled" name="openTimeOnWeekend" id="openTimeOnWeekend" value=<%= library.getOpenTimeOnWeekend() %>>——<input class="item1" type="text" disabled="disabled" name="endTimeOnWeekend" id="endTimeOnWeekend" value=<%= library.getEndTimeOnWeekend() %>></td></tr>

<tr>
<td>馆长姓名:</td>
<td class="librarier"><input type="text" class="item" disabled="disabled" name="librarier" id="librarier" value=<%= library.getLibrarier() %>></td></tr>

<tr>
<td>馆长联系方式:</td>
<td class="linkTel"><input type="text" class="item" disabled="disabled" name="linkTel" id="linkTel" value=<%= library.getLinkTel() %>></td></tr>

<tr>
<td>馆长邮箱:</td>
<td class="linkEmail"><input type="text" class="item" disabled="disabled" name="linkEmail" id="linkEmail" value=<%= library.getLinkEmail() %>></td></tr>

<tr>
<td>馆长地址:</td>
<td class="linkAddress"><input type="text" class="item" disabled="disabled" name="linkAddress" id="linkAddress" value=<%= library.getLinkAddress() %>></td></tr>

<tr>
<td>图书馆简介:</td>
<td class="summary"><textarea class="item0" rows="20" cols="90" disabled="disabled" name="summary" id="summary"><%= library.getSummary() %></textarea></td></tr>
</table>
<div style="position:relative;left:800px;">
<input type="button" value="修改" id="alter">&nbsp;
<input type="submit" value="提交" id="submit">
</div>
</form>
</div>

<div class="clearfloat"></div>
<div class="footer">
联系我们<br/>
<a href="http://www.gzlib.gov.cn" target="_blank">广州图书馆</a><br/>
<address>address:广东省广州市华南理工大学西十七学生宿舍</address>
tel:18813297512
</div>
</div>
</body>
</html>