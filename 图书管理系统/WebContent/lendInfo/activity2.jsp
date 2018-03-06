<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.lendInfo.LibInfoBean" %>
<%@ page import="com.lendInfo.LendInfoBean" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#submit").bind("click",function(){
		var $returnValue=true;
		var $renewTime=$("#renewTime").val();
		if($renewTime==""){
			alert("值不能为空!");
			$returnValue=false;
		}else if(!/^[1-9][0-9]*$/.test($renewTime)){
			alert("请输入正确的数值!");
			$returnValue=false;
		}else if($renewTime>60){
			alert("借书时间不能超过60天噢!");
			$returnValue=false;
		}else if($renewTime<10){
			alert("借书时间不能低于10天噢!");
			$returnValue=false;
		}
		return $returnValue;
	});	
});
</script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/lendInfo/main.css"/>
<title>查看详情</title>
</head>
<body>
<% 
Object libInfo=request.getAttribute("libInfo"); 
LibInfoBean libInfo0=new LibInfoBean();
if(libInfo instanceof LibInfoBean){
	libInfo0=(LibInfoBean)libInfo;
}
Object lendInfo=request.getAttribute("lendInfo"); 
LendInfoBean lendInfo0=new LendInfoBean();
if(lendInfo instanceof LendInfoBean){
	lendInfo0=(LendInfoBean)lendInfo;
}

%>
<div>
<form action="<%=request.getContextPath() %>/RenewBookServlet1?id=<%=libInfo0.getId()%>" method="post">
<table class="libtypeContent" style="width:500px;">
<tr><td>图书条形码</td><td><%=libInfo0.getBarcode()%></td></tr>
<tr><td>书名</td><td><%=libInfo0.getBookname()%></td></tr>
<tr><td>作者</td><td><%=libInfo0.getAuthor()%></td></tr>
<tr><td>翻译</td><td><%=libInfo0.getTranslator()%></td></tr>
<tr><td>价格</td><td><%=libInfo0.getPrice()%></td></tr>
<tr><td>页码</td><td><%=libInfo0.getPage()%></td></tr>
<tr><td>书架</td><td><%=libInfo0.getBookcase()%></td></tr>
<tr><td>图书类型</td><td><%=libInfo0.getTypename()%></td></tr>
<tr><td>进馆时间</td><td><%=libInfo0.getGetInTime()%></td></tr>
<tr><td>被借次数</td><td><%=libInfo0.getBeenLendedTimes()%></td></tr>
<tr><td>可借天数</td><td><%=libInfo0.getCanReadDays()%></td></tr>
<tr><td>借书时间</td><td><%=lendInfo0.getStartTime()%></td></tr>
<tr><td>已经续借</td><td><%=lendInfo0.getAddDays()%></td></tr>
<tr><td></td><td>续借时间:<input type="text" size="8" name="renewTime" id="renewTime">天
<input type="submit" id="submit" value="提交"></td></tr>
</table>
</form>
</div>
</body>
</html>