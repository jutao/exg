function checkFormForCreateOrUpdate() {

	$("#invalid").val($("#invalidSelect").find("option:selected").val());
	var text="";
	var checkArray=document.getElementsByName("varietiescheck");  
	for(var i=0;i<checkArray.length;i++){
		if(checkArray[i].checked){
          text=text+checkArray[i].value+",";
		}
	}
	$("#varieties").val(text);	

	return true;
}

function checkFormForQuery() {
	$("#invalid").val($("#invalidSelect").find("option:selected").val());
	return true;
}

function finder() {
	if (checkFormForQuery() == true) {
		$("#start").val('0');
		var form = $("#form1");
		$("#trid").css('display', 'none');
		$("#load").css('display', '');
		form.submit();
	}
}
$(function() {

	$("#logout").click(function() {
		window.location.href = 'LoginAction.action?action=logout';
	});
});
function submit(formId, actionStr) {
	$("#trid").css('display', 'none');
	$("#load").css('display', '');
	$("#" + formId).attr("action", actionStr).submit();
}