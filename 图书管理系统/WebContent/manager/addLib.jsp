<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("tr td:even").css("width","100px");
	$("tr td:even").css("text-align","center");
	$("tr td:odd").css("width","400px");
	$("tr td:odd").css("text-align","left");
	$("#submit").bind("click",function(){
		var $returnValue=true;
		var $typename=$("#typename").val();
		var $canReadDays=$("#canReadDays").val();
		var $barcode=$("#barcode").val();
		var $page=$("#page").val();
		var $bookname=$("#bookname").val();
		
		if($typename==""){
			$(".frm1").text("*图书类型不允许为空");
			$(".frm1").addClass("item");
			$returnValue=false;
		}else if(!/^[0-5]{1}$/.test($typename)){
			$(".frm1").text("*请输入0-5数值");
			$(".frm1").addClass("item");
			$returnValue=false;
		}else{
			$(".frm1").text("");
		}
		
		if($canReadDays==""){
			$(".frm2").text("");
		}else if(!/^[1-9][0-9]$/.test($canReadDays)){
			$(".frm2").text("*请输入10-99的数值");
			$(".frm2").addClass("item");
			$returnValue=false;
		}else{
			$(".frm2").text("");
		}	
		
		if($barcode==""){
			$(".frm3").text("");
		}else if(!/^9[0-9]{12}$/.test($barcode)){
			$(".frm3").text("*请输入正确的条形码");
			$(".frm3").addClass("item");
			$returnValue=false;
		}else{
			$(".frm3").text("");
		}
		
		if($page==""){
			$(".frm4").text("");
		}else if(!/^[1-9][0-9]{0,4}$/.test($page)){
			$(".frm4").text("*请输入正确的页码数");
			$(".frm4").addClass("item");
			$returnValue=false;
		}else{
			$(".frm4").text("");
		}	
		
		if($bookname==""){
			$(".frm5").text("*书名不允许为空");
			$(".frm5").addClass("item");
			$returnValue=false;
		}else{
			$(".frm5").text("");
		}
		
		return $returnValue;
	});
});
</script>
<style type="text/css">
table.libtypeContent{
	margin:0px auto;
	border-collapse:collapse;
}
td{
	height:30px;
	border:0px;
}
.item{
	color:red;
}
</style>
<title>管理员添加图书</title>
</head>
<body>
<div>
<form action="<%=request.getContextPath() %>/AddLibServlet" method="post">
<table class="libtypeContent" style="width:500px;">
<tr><td>图书条形码</td><td><input type="text" name="barcode" id="barcode" size="25"><span class="frm3"></span></td></tr>
<tr><td>书名</td><td><input type="text" name="bookname" id="bookname" size="25"><span class="frm5"></span></td></tr>
<tr><td>作者</td><td><input type="text" name="author" id="author" size="25"></td></tr>
<tr><td>翻译</td><td><input type="text" name="translator" id="translator" size="25"></td></tr>
<tr><td>价格</td><td><input type="text" name="price" id="price" size="25"></td></tr>
<tr><td>页码</td><td><input type="text" name="page" id="page" size="25"><span class="frm4"></span></td></tr>
<tr><td>书架</td><td><input type="text" name="bookcase" id="bookcase" size="25"></td></tr>
<tr><td>图书类型</td>
<td><input type="text" name="typename" id="typename" size="25"><span class="frm1"></span></td></tr>
<!-- <tr><td>进馆时间</td><td><input type="text" name="getInTime" id="getInTime" size="30" placeholder="默认为此时"></td></tr> -->
<!-- <tr><td>被借次数</td><td><input type="text" name="beenLendedTimes" id="beenLendedTimes" size="30"></td></tr> -->
<tr><td>可借天数</td>
<td><input type="text" name="canReadDays" id="canReadDays" size="25" placeholder="默认30天"><span class="frm2"></span></td></tr>
</table>
<input type="submit" name="submit" id="submit" style="position:relative;left:700px;" value="提交">
</form>
</div>
</body>
</html>