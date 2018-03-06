/**
 * 
 */
$(document).ready(function(){
	$("tr td:even").addClass("td1");
});

$(document).ready(function(){
	$("#alter").bind("click",function(){
		$(".item0").removeAttr("disabled");
		$(".item1").removeAttr("disabled");
		$(".item").removeAttr("disabled");
	});
});