function requireCheck(elem){
	var must=$("#"+elem).val();
	must=trim(must);
	if(must==undefined||must==''){
		$("#"+elem+"_valid").text("必填项！");
		$("#"+elem).focus();
		return false
	}else{
		$("#"+elem+"_valid").text(" ");
		return true;
	}
}

function idRemote(data1){
	$.post("ValidationServlet","data="+data1+"&index=1003&returnFlag=false",function(data,status){
		data=data.replace("\r\n","");
		//文档编号唯一性检查
		if(data=='false'){
			$("#document_no_valid2").text("文档编号已存在");
		}else{
			$("#document_no_valid2").text(" ");
		}
	});
}

function checkFormForCreateOrUpdate(){
	//必填项
	if (!requireCheck("document_no")) {return false;} //文档编号
	if (!requireCheck("template_name")) {return false;} //模板名称
	if (!requireCheck("title")) {return false;} //协议标题
	if (!requireCheck("body")) {return false;} //模板路径
	
	return true;
}

function checkFormForQuery(){

		

	return true;
}

$(function(){

	$("#logout").click(function(){
		window.location.href='LoginAction.action?action=logout';
	});
	
});

var XMLHttpReq = false;
//创建XMLHttpRequest对象
function createXMLHttpRequest(){
	 if(window.XMLHttpRequest){
		 	XMLHttpReq = new XMLHttpRequest();
		 }else if(window.ActiveXobject){
		 try{
			 XMLHttpReq = new ActiveXobject("Msxm12.XMLHTTP");
		 }catch(e){
			 try{
			 XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
		 }catch(e){}
		 }
	 }
}
function UpladFile() {
	
	if (document.getElementById("file").files[0]==undefined) {
		alert("请选择上传文件！");
		return;
	}
	if (!requireCheck("document_no")) {return;} //文档编号
	ShowDiv('fade');
	var fileObj = document.getElementById("file").files[0]; // js 获取文件对象
	var FileController = "DocUploadServlet";                    // 接收上传文件的后台地址

	// FormData 对象
	var form = new FormData();
	// 可以增加表单数据
	form.append("page_id", "risk_warning");
	form.append("document_no", $("#document_no").val());
	form.append("file", fileObj);                           // 文件对象


	// XMLHttpRequest 对象
	createXMLHttpRequest();

	XMLHttpReq.open("post", FileController);
	  
	XMLHttpReq.onreadystatechange = processResponse;   //指定回调函数

	XMLHttpReq.send(form);

}

function processResponse(){
	if(XMLHttpReq.readyState == 4){
		if(XMLHttpReq.status == 200){
//			alert(XMLHttpReq.responseXML.getElementsByTagName("returnFlg")[0].firstChild.nodeValue);
			$("#body").val(XMLHttpReq.responseText);
			alert("上传成功!");
		}else{
			alert("上传失败!");
		}
		HideDiv('fade');
	}
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