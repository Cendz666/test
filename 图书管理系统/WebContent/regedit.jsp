<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/regedit.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/layout.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css"/>
<title>用户注册</title>
</head>
<body>
<div class="container">
<div class="header"><img src="<%=request.getContextPath()%>/images/image2.jpg" alt="欢迎来到图书管理系统"/></div>
<div class="menu"></div>
<div class="clearfloat"></div>
<div class="main">
<!--  logo标志   -->
<div class="logo"><img src="<%=request.getContextPath()%>/images/image1.jpg" alt="图书管理系统logo"/></div>

<!-- 用户注册模块 -->
<div class="frm">
<form action="<%=request.getContextPath()%>/UserRegeditServlet" method="post">
<label for="userName">用 户 名:</label><input type="text" size="20" name="userName" id="userName" placeholder="不超过15个字符"/>
<span class="frm1"></span>
<br /><br />
<label for="tel">手&nbsp;&nbsp;机:</label><input type="text" size="20" name="tel" id="tel" placeholder="请输入11位长的手机号"/>
<span class="frm2"></span>
<br /><br />
<label for="userPsd">密&nbsp;&nbsp;码:</label><input type="password" size="20" name="userPsd" id="userPsd" placeholder="6-20位字符"/>
<span class="frm3"></span>

<br /><br />
<label for="userPsd1">确认密码:</label><input type="password" size="20" name="userPsd1" id="userPsd1" placeholder="确认密码"/>
<span class="frm4"></span>
<div class="button">
<input type="submit" name="submit" id="submit" value="提交"/>&nbsp;
<input type="submit" name="reset" id="reset" value="重置"/>
</div>
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