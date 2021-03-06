<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Order_mastercreate</title>
    <style>.doubleselect br{display:none}</style>
    <meta http-equiv="Cache-Control" content="no-store">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="0">
    <LINK href="../theme/style.css" rel="stylesheet" type="text/css">
	<base href="<%=basePath%>">
	<!--必须先加载否则js中的jquery脚本会报错未定义-->
	<script language="javascript" src="edu/jt/exg/js/jquery-1.11.1.js"></script>
    <script language="javascript" src="edu/jt/exg/js/public.js"></script>
    <script language="javascript" src="edu/jt/exg/js/order_master.js"></script>
    <style type="text/css">
		<!--
		  body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
		  }
		-->
	</style>
    <sx:head/>
    <script language="javascript">
    	$(function(){
    		//等待加载editor控件
		//************************************************************************************************************
		var ajaxFlag=true;//通过所有ajax验证的标志位
		$("#s").click(function(){
			if(checkFormForCreateOrUpdate()==true){
			    			var data1="";

					//所有需要ajax验证的都要在这里完成
					if(ajaxFlag==true){//只要=false就认为有验证不通过
						//防止重复提交
						ShowDiv('fade');
						$("#form1").attr("action", "edu/jt/exg/action/Order_masterAction.action?action=create").submit();
					}else alert('<s:text name="Common.ValidationFailAlert"/>');
				}
			});
			
			$("#b").click(function(){
				window.location.href='<%=basePath%>/edu/jt/exg/action/Order_masterAction.action?action=initquery';
			});
		});
	</script>
</head>
<body>
<s:form id="form1" name="form1" action="" namespace="/edu/jt/exg/action"><br>
<s:text name="Logo.CurrentPosition"/>>>XXX
		<TABLE style="width:auto" border="1" bordercolordark="#FFFFFF" bordercolorlight="cccccc" cellpadding="3" cellspacing="0" align="center">
			<TR><TD colspan="2" class="titlebg"><s:text name="Common.Create_New"/></TD></TR>
			
<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_master.Orderid"/></s:div></TD>
	<TD><s:textfield id="orderid" name="orderid" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_master.Repair_userkey"/></s:div></TD>
	<TD><s:textfield id="repair_userkey" name="repair_userkey" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_master.Outcome"/></s:div></TD>
	<TD><s:textfield id="outcome" name="outcome" cssClass="text" size="15"/></TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_master.Outcome_image1"/></s:div></TD>
	<TD>
		<s:hidden id="outcome_image1" name="outcome_image1"></s:hidden>
		<iframe id="outcome_image1FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=init&readMode=no&type=img&id=" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_master.Outcome_image2"/></s:div></TD>
	<TD>
		<s:hidden id="outcome_image2" name="outcome_image2"></s:hidden>
		<iframe id="outcome_image2FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=init&readMode=no&type=img&id=" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_master.Outcome_image3"/></s:div></TD>
	<TD>
		<s:hidden id="outcome_image3" name="outcome_image3"></s:hidden>
		<iframe id="outcome_image3FileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=init&readMode=no&type=img&id=" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_master.Status"/></s:div></TD>
	<TD>
		<s:hidden id="status" name="status"></s:hidden>
		<s:select id="statusSelect" name="statusSelect" list="statusMap" cssClass="select"/>
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="Order_master.Invalid"/></s:div></TD>
	<TD>
		<s:hidden id="invalid" name="invalid"></s:hidden>
		<s:select id="invalidSelect" name="invalidSelect" list="invalidMap" cssClass="select"/>
	</TD>
</TR>

		</TABLE>
	</s:form>
		<p align="center">
			<button id="s" class="button qing" style="width:110px; height:24px" title=<s:text name="Common.Submit"/> ondblclick="javascript:void(0);"><s:text name="Common.Submit"/></button>&nbsp;
			<button id="b" class="button qing" style="width:110px; height:24px" title=<s:text name="Common.Back"/>><s:text name="Common.Back"/></button>
		</p>
<div id="fade" class="black_overlay" style="text-align:center;">
<img src="<%=basePath%>/edu/jt/exg/images/loading51.gif" width="124" height="124" style=" margin-top:20%"></div>
</body>
</html>