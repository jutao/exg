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
	

	//正整数
	
			var display=$("#display").val();
		display=trim(display);
		if(display!=''){
			if(isNumber(display)==false){
				alert('display must be positive number!');
				return false;
			}
		}
		$("#display").val(display);
		


	//正小数
	
	

	//editor处理
	
	

	//上传处理
	
	

	//s:optiontransferselect处理
	
	
	

		

	
	//手动timestamp的时、分处理
	
	
	return true;
}

function checkFormForQuery(){
	//正整数
	/*
			var displayFrom=$("#displayFrom").val();
		displayFrom=trim(displayFrom);
		if(displayFrom!=''){
			if(isNumber(displayFrom)==false){
				alert('displayFrom must be positive number!');
				return false;
			}
		}
		$("#displayFrom").val(displayFrom);
		var displayTo=$("#displayTo").val();
		displayTo=trim(displayTo);
		if(displayTo!=''){
			if(isNumber(displayTo)==false){
				alert('displayTo must be positive number!');
				return false;
			}
		}
		$("#displayTo").val(displayTo);
		
*/

	//正小数
	
	
	
	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
	$("#invalid").val($("#invalidSelect").find("option:selected").val());
		


	//手动timestamp的时、分处理
	
	
	
	//自动timestamp的时、分处理
	/*
			$("#register_timeHourFrom").val($("#register_timeHourSelectFrom").find("option:selected").val());
		$("#register_timeMinuteFrom").val($("#register_timeMinuteSelectFrom").find("option:selected").val());
		$("#register_timeHourTo").val($("#register_timeHourSelectTo").find("option:selected").val());
		$("#register_timeMinuteTo").val($("#register_timeMinuteSelectTo").find("option:selected").val());
		
		$("#update_timeHourFrom").val($("#update_timeHourSelectFrom").find("option:selected").val());
		$("#update_timeMinuteFrom").val($("#update_timeMinuteSelectFrom").find("option:selected").val());
		$("#update_timeHourTo").val($("#update_timeHourSelectTo").find("option:selected").val());
		$("#update_timeMinuteTo").val($("#update_timeMinuteSelectTo").find("option:selected").val());*/
		

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