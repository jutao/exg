function checkFormForCreateOrUpdate(){
	
		$("#gender").val($("#genderSelect").find("option:selected").val());
		
		$("#address_province").val($("#address_provinceSelect").find("option:selected").val());
		
		$("#address_city").val($("#address_citySelect").find("option:selected").val());
		
		$("#address_area").val($("#address_areaSelect").find("option:selected").val());
		
		$("#bankname").val($("#banknameSelect").find("option:selected").val());
		
		$("#category").val($("#categorySelect").find("option:selected").val());
		
		$("#invalid").val($("#invalidSelect").find("option:selected").val());
		
		var text="";
		var checkArray=document.getElementsByName("usertypecheck");  
		for(var i=0;i<checkArray.length;i++){
			if(checkArray[i].checked){
	          text=text+checkArray[i].value+",";
			}
		}
		$("#usertype").val(text);
	
	return true;
}

function checkFormForQuery(){
	//s:select处理
	
		$("#gender").val($("#genderSelect").find("option:selected").val());
		
		$("#address_province").val($("#address_provinceSelect").find("option:selected").val());
		
		$("#address_city").val($("#address_citySelect").find("option:selected").val());
		
		$("#address_area").val($("#address_areaSelect").find("option:selected").val());
		
		$("#bankname").val($("#banknameSelect").find("option:selected").val());
		
		$("#category").val($("#categorySelect").find("option:selected").val());
		
		$("#invalid").val($("#invalidSelect").find("option:selected").val());
		
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
$(function() {

	$("#logout").click(function() {
		window.location.href = 'LoginAction.action?action=logout';
	});
});
function submit(formId,actionStr){
		$("#trid").css('display','none'); 
		$("#load").css('display','');
		$("#" + formId).attr("action", actionStr).submit();
}