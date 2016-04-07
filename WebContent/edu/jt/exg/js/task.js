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
		


	//editor处理
	
	

	//上传处理
	
			if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("pro_image1").value=document.getElementById("pro_image1FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("pro_image1").value=window.frames["pro_image1FileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("pro_image2").value=document.getElementById("pro_image2FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("pro_image2").value=window.frames["pro_image2FileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("pro_image3").value=document.getElementById("pro_image3FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("pro_image3").value=window.frames["pro_image3FileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("pro_image4").value=document.getElementById("pro_image4FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("pro_image4").value=window.frames["pro_image4FileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("pro_image5").value=document.getElementById("pro_image5FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("pro_image5").value=window.frames["pro_image5FileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("solve_image1").value=document.getElementById("solve_image1FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("solve_image1").value=window.frames["solve_image1FileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("solve_image2").value=document.getElementById("solve_image2FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("solve_image2").value=window.frames["solve_image2FileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("solve_image3").value=document.getElementById("solve_image3FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("solve_image3").value=window.frames["solve_image3FileUpload"].document.getElementById("saveFiles").value;}
		


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