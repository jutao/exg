function checkFormForCreateOrUpdate(){
	//必填项

	

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
	
			var price=$("#price").val();
		price=trim(price);
		if(price!=''){
			if(isPositiveDecimal(price)==false){
				alert('price number must be positive decimal!');
				return false;
			}
		}
		$("#price").val(price)
		


	//editor处理
	
	

	//上传处理
	
			if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("top_pic1").value=document.getElementById("top_pic1FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("top_pic1").value=window.frames["top_pic1FileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("pic1").value=document.getElementById("pic1FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("pic1").value=window.frames["pic1FileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("pic2").value=document.getElementById("pic2FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("pic2").value=window.frames["pic2FileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("pic3").value=document.getElementById("pic3FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("pic3").value=window.frames["pic3FileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("pic4").value=document.getElementById("pic4FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("pic4").value=window.frames["pic4FileUpload"].document.getElementById("saveFiles").value;}
		
		if(navigator.userAgent.indexOf("Firefox")>0){
		document.getElementById("pic5").value=document.getElementById("pic5FileUpload").contentDocument.getElementById("saveFiles").value;
		}else{
		document.getElementById("pic5").value=window.frames["pic5FileUpload"].document.getElementById("saveFiles").value;}
		


	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
			$("#invalid").val($("#invalid").find("option:selected").val());
		

	
	//手动timestamp的时、分处理
	
	
	return true;
}

function checkFormForQuery(){
	//正整数
	
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
		


	//正小数
	
			var priceFrom=$("#priceFrom").val();
		priceFrom=trim(priceFrom);
		if(priceFrom!=''){
			if(isPositiveDecimal(priceFrom)==false){
				alert('priceFrom number must be positive decimal!');
				return false;
			}
		}
		$("#priceFrom").val(priceFrom);
		var priceTo=$("#priceTo").val();
		priceTo=trim(priceTo);
		if(priceTo!=''){
			if(isPositiveDecimal(priceTo)==false){
				alert('priceTo number must be positive decimal!');
				return false;
			}
		}
		
		$("#priceTo").val(priceTo);

	
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