function checkFormForCreateOrUpdate(){
	//s:select处理
	
		$("#status").val($("#statusSelect").find("option:selected").val());
		
		$("#invalid").val($("#invalidSelect").find("option:selected").val());
		

	
	//手动timestamp的时、分处理
	
	
	return true;
}

function checkFormForQuery(){
	
	//s:select处理
	
		$("#status").val($("#statusSelect").find("option:selected").val());
		
		$("#invalid").val($("#invalidSelect").find("option:selected").val());
		


	return true;
}
$(function() {

	$("#logout").click(function() {
		window.location.href = 'LoginAction.action?action=logout';
	});
});
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