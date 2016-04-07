function checkFormForCreateOrUpdate(){
	//必填项

	

	//正整数
	
			var specifications_total=$("#specifications_total").val();
		specifications_total=trim(specifications_total);
		if(specifications_total!=''){
			if(isNumber(specifications_total)==false){
				alert('specifications_total must be positive number!');
				return false;
			}
		}
		$("#specifications_total").val(specifications_total);
		


	//正小数
	
			var weight_total=$("#weight_total").val();
		weight_total=trim(weight_total);
		if(weight_total!=''){
			if(isPositiveDecimal(weight_total)==false){
				alert('weight_total number must be positive decimal!');
				return false;
			}
		}
		$("#weight_total").val(weight_total)
		


	//editor处理
	
	

	//上传处理
	
	

	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
			$("#invalid").val($("#invalid").find("option:selected").val());
		

	
	//手动timestamp的时、分处理
	
	
	return true;
}

function checkFormForQuery(){
	//正整数
	
			var specifications_totalFrom=$("#specifications_totalFrom").val();
		specifications_totalFrom=trim(specifications_totalFrom);
		if(specifications_totalFrom!=''){
			if(isNumber(specifications_totalFrom)==false){
				alert('specifications_totalFrom must be positive number!');
				return false;
			}
		}
		$("#specifications_totalFrom").val(specifications_totalFrom);
		var specifications_totalTo=$("#specifications_totalTo").val();
		specifications_totalTo=trim(specifications_totalTo);
		if(specifications_totalTo!=''){
			if(isNumber(specifications_totalTo)==false){
				alert('specifications_totalTo must be positive number!');
				return false;
			}
		}
		$("#specifications_totalTo").val(specifications_totalTo);
		


	//正小数
	
			var weight_totalFrom=$("#weight_totalFrom").val();
		weight_totalFrom=trim(weight_totalFrom);
		if(weight_totalFrom!=''){
			if(isPositiveDecimal(weight_totalFrom)==false){
				alert('weight_totalFrom number must be positive decimal!');
				return false;
			}
		}
		$("#weight_totalFrom").val(weight_totalFrom);
		var weight_totalTo=$("#weight_totalTo").val();
		weight_totalTo=trim(weight_totalTo);
		if(weight_totalTo!=''){
			if(isPositiveDecimal(weight_totalTo)==false){
				alert('weight_totalTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#weight_totalTo").val(weight_totalTo);

	
	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
			$("#invalid").val($("#invalid").find("option:selected").val());
		


	//手动timestamp的时、分处理
	
	
	
	//自动timestamp的时、分处理
	
			$("#register_timeHourFrom").val($("#register_timeHourSelectFrom").find("option:selected").val());
		$("#register_timeMinuteFrom").val($("#register_timeMinuteSelectFrom").find("option:selected").val());
		$("#register_timeHourTo").val($("#register_timeHourSelectTo").find("option:selected").val());
		$("#register_timeMinuteTo").val($("#register_timeMinuteSelectTo").find("option:selected").val());
		
		$("#update_timeHourFrom").val($("#update_timeHourSelectFrom").find("option:selected").val());
		$("#update_timeMinuteFrom").val($("#update_timeMinuteSelectFrom").find("option:selected").val());
		$("#update_timeHourTo").val($("#update_timeHourSelectTo").find("option:selected").val());
		$("#update_timeMinuteTo").val($("#update_timeMinuteSelectTo").find("option:selected").val());
		

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