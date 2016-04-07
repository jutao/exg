<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>userDetail</title>
    <style>.doubleselect br{display:none}</style>
    <meta http-equiv="Cache-Control" content="no-store">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Expires" content="0">
    <LINK href="../theme/style.css" rel="stylesheet" type="text/css">
	<base href="<%=basePath%>">
    <script language="javascript" src="edu/jt/exg/js/jquery-1.11.1.js"></script>
    <script language="javascript" src="edu/jt/exg/js/public.js"></script>
    <script language="javascript" src="edu/jt/exg/js/user.js"></script>
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
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Level"/></s:div></TD>
	<TD><s:property value="level"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Userid"/></s:div></TD>
	<TD><s:property value="userid"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Name"/></s:div></TD>
	<TD><s:property value="name"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Nickname"/></s:div></TD>
	<TD><s:property value="nickname"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Icon"/></s:div></TD>
	<TD>
		<s:hidden id="icon" name="icon"></s:hidden>
		<iframe id="iconFileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=icon" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Id_number"/></s:div></TD>
	<TD><s:property value="id_number"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Email"/></s:div></TD>
	<TD><s:property value="email"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Gender"/></s:div></TD>
	<TD><s:property value="gender"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Address_province"/></s:div></TD>
	<TD><s:property value="address_province"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Address_city"/></s:div></TD>
	<TD><s:property value="address_city"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Address_area"/></s:div></TD>
	<TD><s:property value="address_area"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Address_details"/></s:div></TD>
	<TD><s:property value="address_details"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Hometown"/></s:div></TD>
	<TD><s:property value="hometown"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Occupation"/></s:div></TD>
	<TD><s:property value="occupation"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Interest"/></s:div></TD>
	<TD><s:property value="interest"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Bankname"/></s:div></TD>
	<TD><s:property value="bankname"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Bank_branch"/></s:div></TD>
	<TD><s:property value="bank_branch"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Card_number"/></s:div></TD>
	<TD><s:property value="card_number"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Balance"/></s:div></TD>
	<TD><s:property value="balance"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Point"/></s:div></TD>
	<TD><s:property value="point"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Recommender_code"/></s:div></TD>
	<TD><s:property value="recommender_code"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Login_password"/></s:div></TD>
	<TD><s:property value="login_password"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Gesture_password"/></s:div></TD>
	<TD><s:property value="gesture_password"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Trading_password"/></s:div></TD>
	<TD><s:property value="trading_password"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Category"/></s:div></TD>
	<TD><s:property value="category"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Usertype"/></s:div></TD>
	<TD><s:property value="usertype"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Qualificat"/></s:div></TD>
	<TD>
		<s:hidden id="qualificat" name="qualificat"></s:hidden>
		<iframe id="qualificatFileUpload" src="${pageContext.request.contextPath}/upload/fileUpload.action?action=getFile&readMode=yes&type=img&id=qualificat" frameBorder="0" marginHeight="0" marginWidth="0" scrolling="Yes" width="600" height="300"></iframe>		
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Yubei1"/></s:div></TD>
	<TD><s:property value="yubei1"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Yubei2"/></s:div></TD>
	<TD><s:property value="yubei2"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Yubei3"/></s:div></TD>
	<TD><s:property value="yubei3"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Invalid"/></s:div></TD>
	<TD><s:property value="invalid"/>&nbsp;</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Register_time"/></s:div></TD>
	<TD>
		<s:date name="register_time" format="yyyy-MM-dd hh:mm:ss"/>&nbsp;
	</TD>
</TR>

<TR class="trbg">
	<TD class="tdbg"><s:div cssClass="center"><s:text name="User.Update_time"/></s:div></TD>
	<TD>
		<s:date name="update_time" format="yyyy-MM-dd hh:mm:ss"/>&nbsp;
	</TD>
</TR>

	</TABLE>
	<p align="center">
		<button id="c" class="button qing" style="width:110px; height:24px"><s:text name="Common.Close"/></button>
	</p>
</body>
</html>