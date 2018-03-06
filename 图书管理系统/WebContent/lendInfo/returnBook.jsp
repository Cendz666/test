<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.user.UserInfoBean" %>
<%@ page import="com.lendInfo.LibInfoBean" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/index.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/lendInfo/main.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/layout.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/menu.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/lendInfo/main.css"/>
<title>读者还书</title>
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
<li class="item0"><a href="<%=request.getContextPath()%>/ReturnBookServlet" >我要还书</a>
</li>
<li class="item0"><a href="<%=request.getContextPath()%>/RenewBookServlet" >我要续借</a>
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
<li class="item-login"><a href="<%=request.getContextPath()%>/login.jsp" >登录</a>|<a href="<%=request.getContextPath()%>/regedit.jsp">注册</a></li>
<% }else{ %>
<li class="item-login">
<a href="<%=request.getContextPath()%>/user/userinfo.jsp" >欢迎光临,<%=user.getUserName()%>
</a>
</li>
<% } %>

</ul>
</div>


<div class="clearfloat"></div>
<div class="main">
<div class="lendBook-up">
<p>以下为您借过的书，请选择要还的项目!</p>
</div>
<div class="lendBook-down">
<!-- <iframe src="" height="100%" weight="100%" id="libtypeContent">
</iframe> -->
<form action="<%=request.getContextPath()%>/ReturnBookServlet1" method="post" name="service" id="service">
<% 
Object list=request.getAttribute("list");
if(list instanceof List<?>){
	List<LibInfoBean> list1=(List<LibInfoBean>)list;
if(list1==null||list1.size()<1){
	out.println("<p>您没有借过书!</p>");
}else{%>
<table id="libtypeContent" class="libtypeContent">
<tr>
<td>书名</td>
<td>作者</td>
<td>图书条形码</td>
<td>价格</td>
<td></td>
</tr>
<% 
	for(LibInfoBean libInfo:list1){
%>
<tr>
<td><%= libInfo.getBookname() %></td>
<td><%= libInfo.getAuthor() %></td>
<td><%= libInfo.getBarcode() %></td>
<td><%= libInfo.getPrice() %></td>
<td><a href="<%= request.getContextPath() %>/ActivityServlet1?id=<%= libInfo.getId() %>" target="_blank">查看详情</a>
<input type="checkbox" name="wantlend" class="wantlend" value=<%= libInfo.getId() %>></td>
</tr>
<%
	}
}
} %>
</table>
<input type="submit"  value="提交" name="lendBook2" id="lendBook2"/>
</form>
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