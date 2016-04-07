﻿<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title><s:text name="文件上传"/></title>
    <meta http-equiv="Cache-Control" content="no-store">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="0">
	
   <!--  <LINK href="theme/style.css" rel="stylesheet" type="text/css"> -->
    <SCRIPT src="js/jquery-pconline.js" type=text/javascript></SCRIPT>
	<SCRIPT src="js/jquery.filestyle.js" type=text/javascript></SCRIPT>
	<script language="javascript" src="js/jquery.min.js"></script>
	<SCRIPT type=text/javascript>
	  $(function() {        
	      $("input.file_1").filestyle({ 
	          image: "images/sourceimg/<s:text name="Common.Input_File_Img"/>",
	          imageheight : 23,
	          imagewidth : 99,
	          width : 150
	      });
	  });
	    
	  window.onresize=resetDIV;   
	  function resetDIV(){ 
	  	with(document.getElementsByTagName("DIV")[0].style){   
	  		left=(document.body.offsetWidth-parseInt(width))/2   
	  		top=(document.body.offsetHeight-parseInt(height))/2   
	  	}   
	  }
	</SCRIPT>
	<script type="text/javascript">
		//浮动层隐藏设置
		function hiddenFloatingLayer(){
			resetDIV();
			var floatingLayer=document.getElementById("floatingLayer");
			floatingLayer.style.display='none';
			var controlsDiv=document.getElementById("controlsDiv");
			controlsDiv.style.display='';
		}
		
		//浮动层显示设置
		function showFloatingLayer(){
			resetDIV();
			var floatingLayer=document.getElementById("floatingLayer");
			floatingLayer.style.display='';
			var controlsDiv=document.getElementById("controlsDiv");
			controlsDiv.style.display='none';
		}
		
		function deleteFile(){
			getOptionsValueAndText("selectFiles","selectedFiles");
			getOptionsValueAndText("delFiles","deletedFiles");
			showFloatingLayer();
			uploadSubmit("form1","${pageContext.request.contextPath}/upload/fileUpload.action?action=deleteFile&readMode=no");
		}
	
		function uploadCheckFile(){
			var flag;
			getOptionsValueAndText("selectFiles","selectedFiles");
			getOptionsValueAndText("delFiles","deletedFiles");
			var file=document.all.myFile.value;
			if(file==""){
				alert('<s:text name="Common.Upload_File_Alert"/>');
				flag=false;
			}else{
				var type=document.all.type.value;
				if(type=="img"){
					var pos = file.lastIndexOf(".");
	 				var lastname = file.substring(pos,file.length); 
	 				if (lastname.toLowerCase()!=".bmp" && lastname.toLowerCase()!=".jpg" && lastname.toLowerCase()!=".png" && lastname.toLowerCase()!=".gif"){
	     				alert('<s:text name="Common.Upload_File_Type"/>' + lastname + '<s:text name="Common.Upload_File_Type_Description"/>');
	     				flag=false;
	     			}else flag=true;
	     		}else flag=true;
     		}
			if(flag==true){
     			showFloatingLayer();
				uploadSubmit("form1","${pageContext.request.contextPath}/upload/fileUpload.action?action=uploadFile&readMode=no");
     		}
		}
		
		//得到选择框的值
		function getOptionsValueAndText(id,hiddenId){
			var select=document.getElementById(id);
			if(isNaN(select)==true){
				var tmpStr="";
				for(var i=0;i<select.options.length;i++) tmpStr+=select.options[i].value + "," + select.options[i].text + "|";
				var hidden=document.getElementById(hiddenId);
				hidden.value=tmpStr.substring(0,tmpStr.length-1);
			}
		}
		
		//iframe得到父页面文件名参数处理
		$(function(){
			hiddenFloatingLayer();
			var url=window.location.href;
			var pos_id = url.indexOf("id");
			var pos_type=url.indexOf("type");
			var pos_readMode=url.indexOf("readMode");
			var id="";
			var type="";
			var readMode="";
			if(pos_id!==-1){
				id=url.substring(pos_id+3,url.length);
				type=url.substring(pos_type+5,pos_id-1);
				readMode=url.substring(pos_readMode+9,pos_type-1);
				if(parent.document.getElementById(id).value!="-1")
					document.all.saveFiles.value=parent.document.getElementById(id).value;
				document.all.type.value=type;
				uploadSubmit("form1","${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=" + readMode);
			}
		});
		
		//上传文件form提交
		function uploadSubmit(formStr,url){
			var form=document.getElementById(formStr);
			form.action=url; 
			form.method = "POST"; 
			form.encoding="multipart/form-data"; 
			form.submit();
		}
		
		//form提交必须写到每个页面
		function submit(form,url){
			form.action=url; 
			form.method = "POST"; 
			form.encoding="application/x-www-form-urlencoded"; 
			form.submit();
		}
	</script>
	<s:head/>
  </head>
  <body>
  	<s:fielderror/>
  	<s:div id="floatingLayer" cssStyle="position:absolute;width=200;height=200;z-index:-100">
  		<img src="${pageContext.request.contextPath}/upload/images/sourceimg/loading.gif">
  	</s:div>
  	<s:form id="form1" name="form1" method="post" enctype="multipart/form-data">
	    	<s:hidden name="type"></s:hidden>
	    	<s:hidden name="saveFiles"></s:hidden>
	    	<s:hidden name="readMode"></s:hidden>
	    <s:div id="controlsDiv">
			<table style="width:auto" border="0" bordercolordark="#FFFFFF" bordercolorlight="cccccc" cellpadding="3" cellspacing="0"> 
			  <tr> 
				<td align="center">
					<s:if test="fileOptionLeftList.size==0">
						<s:if test="type=='img'"><img src ='${pageContext.request.contextPath}/upload/images/sourceimg/<s:text name="Common.NoPhoto_Img"/>'/></s:if>
					</s:if>
					<s:else>
						<s:iterator value="fileOptionLeftList" status="stuts" id="allFiles">
							<s:if test="type=='img'">
								<a href="${pageContext.request.contextPath}/upload/images/<s:property value="#allFiles.key"/>" target="_blank">
									<img src ='${pageContext.request.contextPath}/upload/images/<s:property value="#allFiles.key"/>' width='204' height='272' border='0'/>
								</a>
								<br><a href="${pageContext.request.contextPath}/upload/images/<s:property value="#allFiles.key"/>" target="_blank"><s:property value="#allFiles.value"/></a><br>————————————————<br>
							</s:if>
							<s:else><a href="${pageContext.request.contextPath}/upload/file/<s:property value="#allFiles.key"/>" target="_blank"><s:property value="#allFiles.value"/></a><br>————————————————<br></s:else>
						</s:iterator>
					</s:else>&nbsp;	</td>
			<s:if test="readMode=='no'">
				<td rowspan="2" align="left">
					<s:hidden name="selectedFiles"></s:hidden><s:hidden name="deletedFiles"></s:hidden>
					<s:if test="fileOptionLeftList.size==0 && fileOptionRightList.size==0"></s:if>
					<s:else>
						<s:optiontransferselect
							name="selectFiles" 
							leftTitle="%{getText('Common.Upload_File_Selected')}"
							rightTitle="%{getText('Common.Upload_File_Deleteed')}"
							list="fileOptionLeftList" 
							listKey="key"
							listValue="value"
							multiple="true"
							doubleList="fileOptionRightList"
							doubleListKey="key"
							doubleListValue="value" 
							doubleName="delFiles"
							doubleMultiple="true"
							addAllToRightLabel="—>>"
							addAllToLeftLabel="<<—" 
							addToLeftLabel="<——"
							addToRightLabel="——>"
							addAllToRightOnclick="getOptionsValueAndText('selectFiles','saveFiles');"
							addAllToLeftOnclick="getOptionsValueAndText('selectFiles','saveFiles');"
							addToLeftOnclick="getOptionsValueAndText('selectFiles','saveFiles');"
							addToRightOnclick="getOptionsValueAndText('selectFiles','saveFiles');"
							buttonCssClass="btn_move"
							allowSelectAll="false"
							allowUpDownOnLeft="false"
							allowUpDownOnRight="false"/>
					</s:else>&nbsp;	</td>
			</s:if>
			  </tr>
			<s:if test="readMode=='no'">
			  <tr>
				<td align="right">
					<s:file name ="myFile" cssClass="file_1"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<br>
                    <button class="button qing" style="width:110px; height:24px" title=<s:text name="Common.Upload_File"/> onclick="uploadCheckFile();"><s:text name="Common.Upload_File"/></button>
					&nbsp;&nbsp;&nbsp;&nbsp;
                    <button class="button qing" style="width:110px; height:24px" title=<s:text name="Common.Upload_File_Done"/> onclick="deleteFile();"><s:text name="Common.Upload_File_Done"/></button>
				</td>
				</tr>
			</s:if>
			</table>
  		</s:div>
    </s:form>
  </body>
</html>