$().ready(function() {
		 // 显示顺序验证    
		 jQuery.validator.addMethod("isDisplay", function(value, element) {   
		   return this.optional(element) || /^[0-9]*$/.test(value);    
		 }, "输入格式不正确！");  
		 
	$("#form1").validate(
			
					{
						rules : {
							display:{
								isDisplay:true
							},
							
						},
						messages : {
							
						},
					});
});

function requireCheck(elem) {

	var must = $("#" + elem).val();
	must = trim(must);
	if (must == undefined || must == '') {
		$("#" + elem + "_valid").text("必填项！");
		$("#" + elem).focus();
		return false
	} else {
		$("#" + elem + "_valid").text(" ");
		return true;
	}
}

function checkFormForCreateOrUpdate(){
	//s:select处理
	
	$("#category").val($("#categorySelect").find("option:selected").val());
	$("#invalid").val($("#invalidSelect").find("option:selected").val());
	//必填项
	if (!requireCheck("name")) {return false;} //用户
/*	if (!requireCheck("targetkey")) {return false;} //标的key
	if (!requireCheck("category")) {return false;} //区分*/
	if (!requireCheck("invalid")) {return false;} //有效无效区分
	
	
	
	return true;
}

function checkFormForQuery(){
	
	//s:select处理
	
/*		$("#category").val($("#categorySelect").find("option:selected").val());*/
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