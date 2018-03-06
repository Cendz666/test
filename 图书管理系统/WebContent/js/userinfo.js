/**
 *
 *用户信息
 *
 */
$(document).ready(function(){
	$("td").css("height","30px")
	$("tr td:even").addClass("td1");
	$("tr td:odd").addClass("td2");
});


$(document).ready(function(){
	$("#alter").bind("click",function(){
		$("#sex").bind("click",function(){
		    $(".sex").html("<select name='sex' id='sex' class='userinfo-item' style=><option value='男'>男</option><option value='女'>女</option></select ><span class='item2'></span>");
		});
		$("#papertype").bind("click",function(){
			$(".papertype").html("<select name='papertype' id='papertype' class='userinfo-item' ><option value=''></option><option value='中国居民身份证'>中国居民身份证</option><option value='港澳身份证'>港澳身份证</option></select><span class='item4'></span>");

		});
		$("#birthday").bind("click",function(){
			$(".birthday").html("<input type='date'class='userinfo-item'  name='birthday' id='birthday'><span class='item6'></span>");

		});
		$(".userinfo-item").removeAttr("disabled");
	});
});

$(document).ready(function(){
	$("#submit").bind("click",function(){
		var $returnValue=true;
		var $userName=$("#userName").val();
		var $sex=$("#sex").val();
		var $remark=$("#remark").val();
		var $papertype=$("#papertype").val();
		var $paperNO=$("#paperNO").val();
		var $birthday=$("#birthday").val();
		var $email=$("#email").val();
		
		/* 用户名验证，必须是1-15位正确字符*/
		if($userName==""){
			$(".item1").text("*用户名不允许为空");
			$(".item1").addClass("item");
			$returnValue=false;
		}else if(!/^[\u4e00-\u9fa5\w\.]{1,15}$/.test($userName)){
			$(".item1").text("*请输入1-15位正确的字符");
			$(".item1").addClass("item");
			$returnValue=false;
		}else{
			$(".item1").text("");
		}
		
		
	/* 个人简介验证，不超过256位正确字符  */
		if(!/^[\u4e00-\u9fa5\w\.]{0,256}$/.test($remark)){
			$(".item3").text("*不允许超过256个字符");
			$(".item3").addClass("item");
			$returnValue=false;
		}else{
			$(".item3").text("");
		}
		
	/* 身份证验证   */
    	if($papertype==""){
    		$(".item5").text("");
    		if($paperNO==""){
    			$(".item4").text("");
    		}else{
    			$(".item4").text("*请选择证件类型");
    			$(".item4").addClass("item");
    			$returnValue=false;
    		}
    	}else if($papertype=="中国居民身份证"){
			$(".item4").text("");
    		if($paperNO==""){
    			$(".item5").text("*证件号码不允许为空");
    			$(".item5").addClass("item");
    			$returnValue=false;
    		}else if(!/^\d{18}$/.test($paperNO)){
    			$(".item5").text("*请输入正确的身份证号码")
    			$(".item5").addClass("item");
    			$returnValue=false;
    		}else{
    			$(".item5").text("");
    		}
    	}else if($papertype=="港澳身份证"){
    		$(".item4").text("");
    		if($paperNO==""){
    			$(".item5").text("*证件号码不允许为空");
    			$(".item5").addClass("item");
    			$returnValue=false;
    		}else if(!/^[A-Z]\d{6}\([0-9A]\)$/.test($paperNO)){
    			$(".item5").text("*请输入正确的身份证号码");
    			$(".item5").addClass("item");
    			$returnValue=false;
    		}else{
    			$(".item5").text("");
    		}
    	}
   /*   邮箱验证，可不填      */
		if($email==""){
			$(".item7").text("");
		}else if(!/^[a-z0-9]+([\._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/.test($email)){
			$(".item7").text("*请输入正确格式的邮箱");
			$(".item7").addClass("item");
			$returnValue=false;
		}else{
			$(".item7").text("");
		}
		return $returnValue;
		
	});
});

