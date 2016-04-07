function checkFormForCreateOrUpdate(){
	//必填项

	

	//正整数
	
	

	//正小数
	
	

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
	
	
	
	//s:optiontransferselect处理
	
	
	
	//s:select处理
	
	

	//手动timestamp的时、分处理
	
	
	
	//自动timestamp的时、分处理
	
	
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