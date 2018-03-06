<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.aboutlib.LibraryBean"%>
<%@ page import="com.user.UserInfoBean" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/index.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/aboutlib/main.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/layout.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/aboutlib/main.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/menu.css"/>
<title>有关图书馆</title>
</head>
<body>

<div class="container">
<div class="header"><img src="<%=request.getContextPath()%>/images/image2.jpg" alt="欢迎来到图书管理系统"/></div>
<div class="menu">

<ul class="item" id="item0">

<li class="item" id="item1">
<a href="<%=request.getContextPath()%>/aboutlib/librarier.jsp" id="aboutlib">关于图书馆</a>
<ul class="item0" id="item01">
<li class="item0"><a href="<%=request.getContextPath()%>/aboutlib/librarier.jsp" >馆长信息</a>
</li>
<li class="item0"><a href="<%=request.getContextPath()%>/aboutlib/aboutlib.jsp" >有关图书馆</a>
</li>
<li class="item0"><a href="<%=request.getContextPath()%>/aboutlib/librarySummary.jsp" >图书馆简介</a>
</li>
</ul>
</li>

<li class="item" id="item2">
<a href="<%=request.getContextPath()%>/LendBookServlet?libtype=0&libname=" id="liblend">图书借还</a>
<ul class="item0" id="item02">
<li class="item0"><a href="<%=request.getContextPath()%>/LendBookServlet?libtype=0&libname=" >我要借书</a>
</li>
<li class="item0"><a href="<%=request.getContextPath()%>/lendInfo/returnBook.jsp" >我要还书</a>
</li>
<li class="item0"><a href="<%=request.getContextPath()%>/lendInfo/renewBook.jsp" >我要续借</a>
</li>
</ul>
</li>

<li class="item" id="item3">
<a href="">馆长信箱</a>
</li>

<% 
UserInfoBean user=(UserInfoBean)session.getAttribute("user");
if(user==null){
%>
<li class="item-login"><a href="<%=request.getContextPath()%>/login.jsp" >登录</a>|<a href="../regedit.jsp">注册</a></li>
<% }else{ %>
<li class="item-login">
<a href="<%=request.getContextPath()%>/user/userinfo.jsp" >欢迎光临,<%=user.getUserName()%>
</a>
</li>
<% } %>

</ul>
</div>
<div class="message">
<a id="message" href="https://baike.baidu.com/item/周杰伦/129156?fr=aladdin" title="周杰伦 百度百科" target="_blank">
<img class="message-photo" src="<%=request.getContextPath()%>/images/image4.jpg" /></a></div>
<div class="clearfloat"></div>

<div class="main">
<% LibraryBean library=(LibraryBean)session.getAttribute("library");%>

<div class="left">
<ul class="item-0" id="library">
<li class="item-0"><a href="<%=request.getContextPath()%>/aboutlib/librarier.jsp" class="item-0" id="librarier">&gt;馆长信息</a>
</li>
<li class="item-0"><a href="<%=request.getContextPath()%>/aboutlib/aboutlib.jsp" class="item-0" id="libraryTime">&gt;有关图书馆</a>
</li>
<li class="item-0"><a href="<%=request.getContextPath()%>/aboutlib/librarySummary.jsp" class="item-0" id="librarySummary">&gt;图书馆简介</a>
</li>
</ul>
</div>

<div class="right">
<table>
<tr>
<td>图书馆名字:</td><td><a title="广州图书馆" target="_blank" href="http://www.gzlib.gov.cn/"><%= library.getName() %></a></td></tr>

<tr>
<td>建馆时间:</td><td><%= library.getBuildTime() %></td></tr>

<tr>
<td>图书馆网站:</td><td><a href="http://www.gzlib.gov.cn/" target="_blank" title="图书馆网站"><%= library.getLibWebsite() %></a></td></tr>

<tr>
<td>开馆时间&nbsp;&nbsp;&nbsp;</td><td></td></tr>

<tr>
<td>工作日:</td><td><%= library.getOpenTimeOnWeekday() %>——<%= library.getEndTimeOnWeekday() %></td></tr>

<tr>
<td>休息日:</td><td><%= library.getOpenTimeOnWeekend() %>——<%= library.getEndTimeOnWeekend() %></td></tr>

</table>
</div>
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