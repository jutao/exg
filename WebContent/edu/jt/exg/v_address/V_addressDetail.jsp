<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>v_addressDetail</title>
    <style>.doubleselect br{display:none}</style>
    <meta http-equiv="Cache-Control" content="no-store">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="0">
    <LINK href="../theme/style.css" rel="stylesheet" type="text/css">
	<base href="<%=basePath%>">
    <script language="javascript" src="edu/jt/exg/js/jquery-1.11.1.js"></script>
    <script language="javascript" src="edu/jt/exg/js/public.js"></script>
    <script language="javascript" src="edu/jt/exg/js/v_address.js"></script>
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
    		document.body.style.display='none';   
		window.setTimeout('show()',2000);
	  		
	  	$("#c").click(function(){
			javascript:window.close();
		});
	});
		
	function show(){   
	      	$(document.body).css('display', ''); 
	      	//EDiaryEditor必须延时加载
		
	}
    </script>
</head>
<body><br>
<s:text name="Logo.CurrentPosition"/>>>XXX
	<TABLE style="width:auto" border="1" bordercolordark="#FFFFFF" bordercolorlight="cccccc" cellpadding="3" cellspacing="0" align="center">
		<TR><TD colspan="2" class="titlebg"><s:text name="Common.Detail"/></TD></TR>
		
<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="V_address.Province_name"/></s:div></TD>
	<TD><s:property value="province_name"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="V_address.City_code"/></s:div></TD>
	<TD><s:property value="city_code"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="V_address.City_name"/></s:div></TD>
	<TD><s:property value="city_name"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="V_address.Area_code"/></s:div></TD>
	<TD><s:property value="area_code"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="V_address.Area_name"/></s:div></TD>
	<TD><s:property value="area_name"/>&nbsp;</TD>
</TR>

	</TABLE>
	<p align="center">
		<button id="c" class="button qing" style="width:110px; height:24px"><s:text name="Common.Close"/></button>
	</p>
</body>
</html>