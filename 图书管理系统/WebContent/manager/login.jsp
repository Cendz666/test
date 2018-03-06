<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/layout.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css"/>
<script type="text/javascript">
/**
 * 
 * 管理员登录验证
 */
$(document).ready(function(){
	$("#submit").bind("click",function(){
		var $returnValue=true;
		var $tel=$("#tel").val();
		var $userPsd=$("#userPsd").val();
		/*  用户名验证，11位手机号码     */
		if($tel==""){
			$(".frm1").text("*用户名不允许为空");
			$(".frm1").addClass("item");
			$returnValue=false;
		}else if(!/^[\u4e00-\u9fa5\w\\.]{3,15}$/.test($tel)){
			$(".frm1").text("*请输入正确的用户名");
			$(".frm1").addClass("item");
			$returnValue=false;
		}else{
			$(".frm1").text("");
		}
		
		
		/*  密码验证，6-20位字符  */
		if($userPsd==""){
			$(".frm2").text("*请输入密码")
			$(".frm2").addClass("item");
			$returnValue=false;
		}else if(!/^[\u4e00-\u9fa5\w\\.]{3,15}$/.test($userPsd)){
			$(".frm2").text("*请输入正确的密码")
			$(".frm2").addClass("item");
			$returnValue=false;
		}else{
			$(".frm2").text("")
		}
		
		
		return $returnValue;
	});
});
</script>
<title>管理员登录</title>
</head>
<body>
<div class="container">
<div class="header"><img src="<%=request.getContextPath()%>/images/image2.jpg" alt="欢迎来到图书管理系统"/></div>
<div class="menu"></div>
<div class="clearfloat"></div>
<div class="main">
<!--  logo标志   -->
<div class="logo"><img src="<%=request.getContextPath()%>/images/image1.jpg" alt="图书管理系统logo"/></div>

<!-- 用户登录模块 -->
<div class="frm">
<form action="<%=request.getContextPath()%>/ManagerLoginServlet" method="post">
<label for="tel">用户名:</label><input type="text" size="20" name="tel" id="tel" placeholder="请输入用户名"/><span class="frm1"></span>
<br /><br />
<label for="userPsd">密&nbsp;码:</label><input type="password" size="20" name="userPsd" id="userPsd" /><span class="frm2"></span>
<div class="button">
<input type="submit" name="submit" id="submit" value="提交"/>
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