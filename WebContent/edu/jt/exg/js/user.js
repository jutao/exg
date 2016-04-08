function checkFormForCreateOrUpdate(){
	
	

	
			$("#gender").val($("#gender").find("option:selected").val());
		
		$("#address_province").val($("#address_province").find("option:selected").val());
		
		$("#address_city").val($("#address_city").find("option:selected").val());
		
		$("#address_area").val($("#address_area").find("option:selected").val());
		
		$("#bankname").val($("#bankname").find("option:selected").val());
		
		$("#category").val($("#category").find("option:selected").val());
		
		$("#invalid").val($("#invalid").find("option:selected").val());
		
		var text="";
		var checkArray=document.getElementsByName("usertypecheck");  
		for(var i=0;i<checkArray.length;i++){
			if(checkArray[i].checked){
	          text=text+checkArray[i].value+",";
			}
		}
		$("#usertype").val(text);
	
	//手动timestamp的时、分处理
	
	
	return true;
}

function checkFormForQuery(){
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