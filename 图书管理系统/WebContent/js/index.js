/**
 * 主页导航模块
 * 
 */
$(document).ready(function(){
	$("#aboutlib").hover(function(){
		$("#item01").show();
	},function(){});
	
	$("#item1").hover(function(){},function(){
		$("#item01").hide();
	});
	
	$("#liblend").hover(function(){
		$("#item02").show();
	},function(){});
	
	$("#item2").hover(function(){},function(){
		$("#item02").hide();
	});
});
