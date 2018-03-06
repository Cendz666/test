/**
 * 
 * 用户登录验证
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
		}else if(!/^1[0-9]{10}$/.test($tel)){
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
		}else if(!/^[\u4e00-\u9fa5\w\\.]{6,20}$/.test($userPsd)){
			$(".frm2").text("*请输入6-20位字符")
			$(".frm2").addClass("item");
			$returnValue=false;
		}else{
			$(".frm2").text("")
		}
		
		
		return $returnValue;
	});
});