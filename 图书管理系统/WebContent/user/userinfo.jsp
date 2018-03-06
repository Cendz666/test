<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.user.UserInfoBean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/userinfo.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/layout.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/userinfo.css"/>
<title>个人信息</title>
</head>
<body>
<div class="container">
<div class="header"><img src="<%=request.getContextPath()%>/images/image2.jpg" alt="欢迎来到图书管理系统"/></div>
<div class="menu"></div>
<div class="clearfloat"></div>
<div class="main">
<div class="userinfo">
<% UserInfoBean user=(UserInfoBean)session.getAttribute("user");  %>
<form action="<%=request.getContextPath()%>/UserInfoServlet" method="post" name="infofrm" id="infofrm">
<table>
<!--  <colgroup span="2">
<col span="1" class="infoitem" />
<col span="1" class="infovalue" />
</colgroup>-->
 <tr>
 <td>用户名:</td>
 <td><input type='text' class='userinfo-item' disabled="disabled" name='userName' id='userName' value=<%= user.getUserName() %> style="color:black;">
 <span class="item1"></span>
 </td>
 </tr>
 
<tr>
<td>性别:</td>
<td class="sex"><input type="text" class='userinfo-item' disabled="disabled" name='sex' id='sex' value=<%= user.getSex() %>>
<span class="item2"></span>
</td>
</tr>

<tr>
<td>简介:</td>
<td><textarea cols=""  name="remark" id="remark" class="userinfo-item" disabled="disabled" ><%= user.getRemark() %></textarea>
<span class="item3"></span>
</td>
</tr>

<tr>
<td>证件类型:</td>
<td class="papertype"><input type='text' class='userinfo-item' disabled="disabled" name='papertype' id='papertype' value=<%= user.getPapertype() %>>
<span class="item4"></span>
</td>
</tr>

<tr>
<td>证件号码:</td>
<td><input type="text" disabled="disabled" name="paperNO" id="paperNO" class="userinfo-item" value=<%= user.getPaperNO() %>>
<span class="item5"></span>
</td>
</tr>

<tr>
<td>生日:</td>
<td class="birthday"><input type="text" disabled="disabled" name="birthday" id="birthday" class="userinfo-item" value=<%= user.getBirthday() %>>
<span class="item6"></span>
</td>
</tr>

<tr>
<td>邮箱:</td>
<td><input type="text" disabled="disabled" name="email" id="email" class="userinfo-item" value=<%= user.getEmail() %>>
<span class="item7"></span>
</td>
</tr>

<tr>
<td>注册时间:</td>
<td><input type="text" disabled="disabled" name="regeditTime" id="regeditTime"  value=<%= user.getRegeditTime() %>>
<span class="item8"></span>
</td>
</tr>

<tr>
<td></td>
<td style="text-align:left">
&nbsp;
<input type="button" name="alter"  id="alter"  value="修改">
&nbsp;
<input type="submit" name="submit" id="submit" disabled="disabled" class="userinfo-item" value="提交">
</td>
</tr>
</table>
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