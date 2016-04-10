function checkFormForCreateOrUpdate(){
	
	return true;
}

function checkFormForQuery(){
	$("#invalid").val($("#invalidSelect").find("option:selected").val());
	$("#status").val($("#statusSelect").find("option:selected").val());
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
$(function() {

	$("#logout").click(function() {
		window.location.href = 'LoginAction.action?action=logout';
	});
});