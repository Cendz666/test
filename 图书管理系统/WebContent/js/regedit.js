/**
 * 
 * 用户注册信息验证
 */
$(document).ready(function(){
	$("#submit").bind("click",function(){
		var $returnValue=true;
		var $userName=$("#userName").val();
		var $tel=$("#tel").val();
		var $userPsd=$("#userPsd").val();
		var $userPsd1=$("#userPsd1").val();
		
		/* 用户名验证   */
		if($userName==""){
			$(".frm1").text("*用户名不允许为空");
			$(".frm1").addClass("item");
			$returnValue=false;
		}else if(!/^[\u4e00-\u9fa5\w\.]{1,15}$/.test($userName)){
			$(".frm1").text("*请输入1-15位正确的字符");
			$(".frm1").addClass("item");
			$returnValue=false;
		}else{
			$(".frm1").text("");
		}
		
		/*  手机号码验证，11位手机号码     */
		if($tel==""){
			$(".frm2").text("*手机号码不允许为空");
			$(".frm2").addClass("item");
			$returnValue=false;
		}else if(!/^1[0-9]{10}$/.test($tel)){
			$(".frm2").text("*请输入正确的手机号码");
			$(".frm2").addClass("item");
			$returnValue=false;
		}else{
			$(".frm2").text("");
		}
		
		
		/*  密码验证，6-20位字符  */
		if($userPsd==""){
			$(".frm3").text("*请输入密码");
			$(".frm3").addClass("item");
			$(".frm4").text("");
			$returnValue=false;
		}else if($userPsd1==""){
			$(".frm4").text("*请输入密码");
			$(".frm4").addClass("item");
			$(".frm3").text("");
			$returnValue=false;
		}else if(!/^[\u4e00-\u9fa5\w\\.]{6,20}$/.test($userPsd)){
			$(".frm3").text("*请输入6-20位字符");
			$(".frm3").addClass("item");
			$(".frm4").text("");
			$returnValue=false;
		}else if($userPsd!=$userPsd1){
			$(".frm4").text("*须与上面的密码相同!");
			$(".frm4").addClass("item");
			$(".frm3").text("");
			$("#userPsd").focus();
			$returnValue=false;
		}else{
			$(".frm3").text("");
			$(".frm4").text("");
		}
		
		return $returnValue;
	});
});