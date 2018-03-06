/**
 * 
 */
$(document).ready(function(){
	$("#lendBook2").bind("click",function(){
		var $returnValue=false;
		var $s=$(".wantlend");
		for(i=0;i<$s.length;i++){
			if($s[i].checked){
				$returnValue=true;
				break;
			}
		}
		if($returnValue) {
			return $returnValue;
		}else{
			alert("请选择想借的书!");
			return $returnValue;
		}
	});
});
