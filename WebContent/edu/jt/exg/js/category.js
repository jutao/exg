function requireCheck(elem){
	var must=$("#"+elem).val();
	must=trim(must);
	if(must==undefined||must==''){
		$("#"+elem+"_valid").text("必填项！");
		$("#"+elem).focus();
		return false
	}else{
		$("#"+elem+"_valid").text(" ");
		return true;
	}
}
$(function() {
	
	$("#logout").click(function() {
		window.location.href = 'LoginAction.action?action=logout';
		
	});
});
function checkFormForCreateOrUpdate(){
	//s:select处理
	$("#invalid").val($("#invalidSelect").find("option:selected").val());
	
	//必填项
	if (!requireCheck("code")) {return false;} //子区分
	if (!requireCheck("name")) {return false;} //名称
	if (!requireCheck("invalid")) {return false;} //有效无效区分
	
	return true;
}

function checkFormForQuery(){
	
	$("#invalid").val($("#invalidSelect").find("option:selected").val());

	return true;
}

function finder(){
	if(checkFormForQuery()==true){
		$("#start").val('0');
		var form=$("#form1");
		$("#trid").css('display','none'); 
		$("#load").css('display','');
		form.submit();
	}
}

function submit(formId,actionStr){
		$("#trid").css('display','none'); 
		$("#load").css('display','');
		$("#" + formId).attr("action", actionStr).submit();
}