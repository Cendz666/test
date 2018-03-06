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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/manager/layout.css"/>

<style type="text/css">
p.select{
	text-align:center;
	font-size:25px;
}
table.libtypeContent{
	margin:0px auto;
	width:1000px;
	border:1px solid;
	border-collapse:collapse;
}
td{
	height:40px;
	text-align:center;
	border:1px solid;
}
</style>

<title>图书信息</title>
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
<form action="<%=request.getContextPath()%>/QueryBookServlet" method="post">
<p class="select" id="select"><span class="libtype">图书类型:</span>
<select name="libtype" class="libtype" id="libtype" style="height:30px;font-size:25px;">
<option value="0"></option>
<option value="1">经济</option>
<option value="2">文学</option>
<option value="3">法律</option>
<option value="4">自然与科学</option>
<option value="5">计算机科学</option>
</select>
&nbsp;&nbsp;
<span class="libname">根据图书名称查询:</span>
<input type="text" name="libname" id="libname" size="20" style="font-size:20px;" />
<input type="submit"  value="查询" id="lendBook1"/>
</p>
</form>

<table id="libtypeContent" class="libtypeContent">
<tr>
<td>书名</td>
<td>作者</td>
<td>图书条形码</td>
<td>价格</td>
<td></td>
</tr>
<% 
Object list=request.getAttribute("list");
if(list instanceof List<?>){
	List<LibInfoBean> list1=(List<LibInfoBean>)list;
if(list1!=null&&list1.size()>0){
	for(LibInfoBean libInfo:list1){
%>
<tr>
<td><%= libInfo.getBookname() %></td>
<td><%= libInfo.getAuthor() %></td>
<td><%= libInfo.getBarcode() %></td>
<td><%= libInfo.getPrice() %></td>
<td><a href="<%= request.getContextPath() %>/LookDetailsServlet?id=<%= libInfo.getId() %>" target="_blank">查看详情</a>
<a style="text-decoration:underline;color:blue;" id="delete" 
href="javascript:if(window.confirm('确定要删除该项纪录吗?')) location='<%= request.getContextPath() %>/DeleteBookServlet?id=<%= libInfo.getId() %>'">删除</a>
</tr>
<%
	}
}
} %>
</table>

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