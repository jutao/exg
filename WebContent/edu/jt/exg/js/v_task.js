function checkFormForCreateOrUpdate(){
	//必填项

	

	//正整数
	
	

	//正小数
	
			var tip=$("#tip").val();
		tip=trim(tip);
		if(tip!=''){
			if(isPositiveDecimal(tip)==false){
				alert('tip number must be positive decimal!');
				return false;
			}
		}
		$("#tip").val(tip)
		
		var epson=$("#epson").val();
		epson=trim(epson);
		if(epson!=''){
			if(isPositiveDecimal(epson)==false){
				alert('epson number must be positive decimal!');
				return false;
			}
		}
		$("#epson").val(epson)
		
		var server_price=$("#server_price").val();
		server_price=trim(server_price);
		if(server_price!=''){
			if(isPositiveDecimal(server_price)==false){
				alert('server_price number must be positive decimal!');
				return false;
			}
		}
		$("#server_price").val(server_price)
		
		var total_price=$("#total_price").val();
		total_price=trim(total_price);
		if(total_price!=''){
			if(isPositiveDecimal(total_price)==false){
				alert('total_price number must be positive decimal!');
				return false;
			}
		}
		$("#total_price").val(total_price)
		


	//editor处理
	
	

	//上传处理
	
	

	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
	
	
	//手动timestamp的时、分处理
	
	
	return true;
}

function checkFormForQuery(){
	//正整数
	
	

	//正小数
	
			var tipFrom=$("#tipFrom").val();
		tipFrom=trim(tipFrom);
		if(tipFrom!=''){
			if(isPositiveDecimal(tipFrom)==false){
				alert('tipFrom number must be positive decimal!');
				return false;
			}
		}
		$("#tipFrom").val(tipFrom);
		var tipTo=$("#tipTo").val();
		tipTo=trim(tipTo);
		if(tipTo!=''){
			if(isPositiveDecimal(tipTo)==false){
				alert('tipTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#tipTo").val(tipTo);
		var epsonFrom=$("#epsonFrom").val();
		epsonFrom=trim(epsonFrom);
		if(epsonFrom!=''){
			if(isPositiveDecimal(epsonFrom)==false){
				alert('epsonFrom number must be positive decimal!');
				return false;
			}
		}
		$("#epsonFrom").val(epsonFrom);
		var epsonTo=$("#epsonTo").val();
		epsonTo=trim(epsonTo);
		if(epsonTo!=''){
			if(isPositiveDecimal(epsonTo)==false){
				alert('epsonTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#epsonTo").val(epsonTo);
		var server_priceFrom=$("#server_priceFrom").val();
		server_priceFrom=trim(server_priceFrom);
		if(server_priceFrom!=''){
			if(isPositiveDecimal(server_priceFrom)==false){
				alert('server_priceFrom number must be positive decimal!');
				return false;
			}
		}
		$("#server_priceFrom").val(server_priceFrom);
		var server_priceTo=$("#server_priceTo").val();
		server_priceTo=trim(server_priceTo);
		if(server_priceTo!=''){
			if(isPositiveDecimal(server_priceTo)==false){
				alert('server_priceTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#server_priceTo").val(server_priceTo);
		var total_priceFrom=$("#total_priceFrom").val();
		total_priceFrom=trim(total_priceFrom);
		if(total_priceFrom!=''){
			if(isPositiveDecimal(total_priceFrom)==false){
				alert('total_priceFrom number must be positive decimal!');
				return false;
			}
		}
		$("#total_priceFrom").val(total_priceFrom);
		var total_priceTo=$("#total_priceTo").val();
		total_priceTo=trim(total_priceTo);
		if(total_priceTo!=''){
			if(isPositiveDecimal(total_priceTo)==false){
				alert('total_priceTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#total_priceTo").val(total_priceTo);

	
	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
	

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