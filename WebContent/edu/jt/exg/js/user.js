function checkFormForCreateOrUpdate(){
	//必填项

	

	//正整数
	
			var level=$("#level").val();
		level=trim(level);
		if(level!=''){
			if(isNumber(level)==false){
				alert('level must be positive number!');
				return false;
			}
		}
		$("#level").val(level);
		
		var point=$("#point").val();
		point=trim(point);
		if(point!=''){
			if(isNumber(point)==false){
				alert('point must be positive number!');
				return false;
			}
		}
		$("#point").val(point);
		


	//正小数
	
			var balance=$("#balance").val();
		balance=trim(balance);
		if(balance!=''){
			if(isPositiveDecimal(balance)==false){
				alert('balance number must be positive decimal!');
				return false;
			}
		}
		$("#balance").val(balance)
		


	//editor处理
	
	

	//上传处理
	
			if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("icon").value=document.getElementById("iconFileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("icon").value=window.frames["iconFileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("qualificat").value=document.getElementById("qualificatFileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("qualificat").value=window.frames["qualificatFileUpload"].document.getElementById("saveFiles").value;}
		


	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
			$("#gender").val($("#gender").find("option:selected").val());
		
		$("#address_province").val($("#address_province").find("option:selected").val());
		
		$("#address_city").val($("#address_city").find("option:selected").val());
		
		$("#address_area").val($("#address_area").find("option:selected").val());
		
		$("#bankname").val($("#bankname").find("option:selected").val());
		
		$("#category").val($("#category").find("option:selected").val());
		
		$("#invalid").val($("#invalid").find("option:selected").val());
		

	
	//手动timestamp的时、分处理
	
	
	return true;
}

function checkFormForQuery(){
	//正整数
	
			var levelFrom=$("#levelFrom").val();
		levelFrom=trim(levelFrom);
		if(levelFrom!=''){
			if(isNumber(levelFrom)==false){
				alert('levelFrom must be positive number!');
				return false;
			}
		}
		$("#levelFrom").val(levelFrom);
		var levelTo=$("#levelTo").val();
		levelTo=trim(levelTo);
		if(levelTo!=''){
			if(isNumber(levelTo)==false){
				alert('levelTo must be positive number!');
				return false;
			}
		}
		$("#levelTo").val(levelTo);
		
		var pointFrom=$("#pointFrom").val();
		pointFrom=trim(pointFrom);
		if(pointFrom!=''){
			if(isNumber(pointFrom)==false){
				alert('pointFrom must be positive number!');
				return false;
			}
		}
		$("#pointFrom").val(pointFrom);
		var pointTo=$("#pointTo").val();
		pointTo=trim(pointTo);
		if(pointTo!=''){
			if(isNumber(pointTo)==false){
				alert('pointTo must be positive number!');
				return false;
			}
		}
		$("#pointTo").val(pointTo);
		


	//正小数
	
			var balanceFrom=$("#balanceFrom").val();
		balanceFrom=trim(balanceFrom);
		if(balanceFrom!=''){
			if(isPositiveDecimal(balanceFrom)==false){
				alert('balanceFrom number must be positive decimal!');
				return false;
			}
		}
		$("#balanceFrom").val(balanceFrom);
		var balanceTo=$("#balanceTo").val();
		balanceTo=trim(balanceTo);
		if(balanceTo!=''){
			if(isPositiveDecimal(balanceTo)==false){
				alert('balanceTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#balanceTo").val(balanceTo);

	
	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
			$("#gender").val($("#gender").find("option:selected").val());
		
		$("#address_province").val($("#address_province").find("option:selected").val());
		
		$("#address_city").val($("#address_city").find("option:selected").val());
		
		$("#address_area").val($("#address_area").find("option:selected").val());
		
		$("#bankname").val($("#bankname").find("option:selected").val());
		
		$("#category").val($("#category").find("option:selected").val());
		
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