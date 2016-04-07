function checkFormForCreateOrUpdate(){
	//必填项

	

	//正整数
	
	

	//正小数
	
			var quantity=$("#quantity").val();
		quantity=trim(quantity);
		if(quantity!=''){
			if(isPositiveDecimal(quantity)==false){
				alert('quantity number must be positive decimal!');
				return false;
			}
		}
		$("#quantity").val(quantity)
		


	//editor处理
	
	

	//上传处理
	
	

	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
			$("#status").val($("#status").find("option:selected").val());
		
		$("#invalid").val($("#invalid").find("option:selected").val());
		

	
	//手动timestamp的时、分处理
	
	
	return true;
}

function checkFormForQuery(){
	//正整数
	
	

	//正小数
	
			var quantityFrom=$("#quantityFrom").val();
		quantityFrom=trim(quantityFrom);
		if(quantityFrom!=''){
			if(isPositiveDecimal(quantityFrom)==false){
				alert('quantityFrom number must be positive decimal!');
				return false;
			}
		}
		$("#quantityFrom").val(quantityFrom);
		var quantityTo=$("#quantityTo").val();
		quantityTo=trim(quantityTo);
		if(quantityTo!=''){
			if(isPositiveDecimal(quantityTo)==false){
				alert('quantityTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#quantityTo").val(quantityTo);

	
	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
			$("#status").val($("#status").find("option:selected").val());
		
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