<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.manager.LibDetailsBean" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.1.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#alter").bind("click",function(){
		$(".libinfo-item").removeAttr("disabled");
	});
	$("#submit").bind("click",function(){
		var $returnValue=true;
		var $typeid=$("#typeid").val();
		var $canReadDays=$("#canReadDays").val();
		var $barcode=$("#barcode").val();
		var $page=$("#page").val();
		var $bookname=$("#bookname").val();
		
		if($typeid==""){
			$(".frm1").text("*图书类型不允许为空");
			$(".frm1").addClass("item");
			$returnValue=false;
		}else if(!/^[0-5]{1}$/.test($typeid)){
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
	width:1000px;
	border:1px solid;
	border-collapse:collapse;
}
td{
    text-align:center;
	height:40px;
	border:1px solid;
}
.td1{
	text-align:center;
}
.libinfo-item{
	border:0px;
	background-color:transparent;
	font-size:20px;
}
.libinfo-item0{
	border:0px;
	background-color:transparent;
	font-size:20px;
}
.item{
	color:red;
}
</style>
<title>查看详情</title>
</head>
<body>
<% 
Object libDetailsBean=request.getAttribute("libDetailsBean"); 
LibDetailsBean libDetailsBean0=new LibDetailsBean();
if(libDetailsBean instanceof LibDetailsBean){
	libDetailsBean0=(LibDetailsBean)libDetailsBean;
}

%>
<div>
<form action="<%=request.getContextPath()%>/AlterLibServlet" method="post">
<input type="hidden" name="libId" id="libId" value=<%=libDetailsBean0.getId()%>>
<table class="libtypeContent" style="width:500px;">
<tr><td>图书条形码</td>
<td><input type='text' class='libinfo-item' disabled="disabled" name='barcode' id='barcode' value=<%=libDetailsBean0.getBarcode()%> ><span class="frm3"></span></td></tr>

<tr><td>书名</td>
<td title="<%=libDetailsBean0.getBookname()%>"><input type='text' class='libinfo-item' disabled="disabled" name='bookname' id='bookname' value=<%=libDetailsBean0.getBookname()%>><span class="frm5"></span></td></tr>

<tr><td>作者</td>
<td><input type='text' class='libinfo-item' disabled="disabled" name='author' id='author' value=<%=libDetailsBean0.getAuthor()%> ></td></tr>

<tr><td>翻译</td>
<td><input type='text' class='libinfo-item' disabled="disabled" name='translator' id='translator' value=<%=libDetailsBean0.getTranslator()%> ></td></tr>

<tr><td>价格</td>
<td><input type='text' class='libinfo-item' disabled="disabled" name='price' id='price' value=<%=libDetailsBean0.getPrice()%> ></td></tr>

<tr><td>页码</td>
<td><input type='text' class='libinfo-item' disabled="disabled" name='page' id='page' value=<%=libDetailsBean0.getPage()%> ><span class="frm4"></span></td></tr>

<tr><td>书架</td>
<td><input type='text' class='libinfo-item' disabled="disabled" name='bookcase' id='bookcase' value=<%=libDetailsBean0.getBookcase()%> ></td></tr>

<tr><td>图书类型</td>
<td><input type='text' class='libinfo-item' disabled="disabled" name='typeid' id='typeid' value=<%=libDetailsBean0.getTypeid()%> ><span class="frm1"></span></td></tr>

<tr><td>进馆时间</td>
<td><input type='text' class="libinfo-item0" disabled="disabled" name='getInTime' id='getInTime' value=<%=libDetailsBean0.getGetInTime()%> ></td></tr>

<tr><td>被借次数</td>
<td><input type='text' class="libinfo-item0" disabled="disabled" name='barcode' id='beenLendedTimes' value=<%=libDetailsBean0.getBeenLendedTimes()%> ><span class="frm2"></span></td></tr>

<tr><td>可借天数</td>
<td><input type='text' class='libinfo-item' disabled="disabled" name='canReadDays' id='canReadDays' value=<%=libDetailsBean0.getCanReadDays()%> ></td></tr>

<tr><td>借阅详情</td>
<td><% if(libDetailsBean0.getIsLended()==1){
	%><a style="text-decoration:none;position:relative;right:80px;" href="<%=request.getContextPath()%>/LookHistoryServlet?libId=<%=libDetailsBean0.getId()%>" title="点击查看借阅历史" >已被借走</a>
	<% }else if(libDetailsBean0.getIsLended()==0){
		%><a style="text-decoration:none;position:relative;right:80px;" href="<%=request.getContextPath()%>/LookHistoryServlet?libId=<%=libDetailsBean0.getId()%>" title="点击查看借阅历史" >未被借走</a>
	<% }%>
	</td></tr>
<tr>
<td></td>
<td style="text-align:left">
&nbsp;&nbsp;
<input type="button" name="alter"  id="alter"  value="修改">
&nbsp;
<input type="submit" name="submit" id="submit" disabled="disabled" class='libinfo-item' value="提交">
</td>
</tr>
</table>
</form>
</div>
</body>
</html>